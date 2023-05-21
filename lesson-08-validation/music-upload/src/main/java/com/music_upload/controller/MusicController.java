package com.music_upload.controller;

import com.music_upload.model.Music;
import com.music_upload.model.MusicForm;
import com.music_upload.service.MusicService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@PropertySource("classpath:upload_music.properties")
public class MusicController {
    private final MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping({"", "/"})
    public String index(Model model) {
        List<Music> musicList = musicService.getAll();
        model.addAttribute("musicList", musicList);
        return "index";
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("musicForm", new MusicForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid MusicForm musicForm,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) throws Exception {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        boolean isSaveSuccessfully = musicService.save(musicForm);
        String message;
        if (isSaveSuccessfully) {
            message = "Saved song \"" + musicForm.getName() + "\" successfully!";
        } else {
            message = "Invalid file. Hưởng only play with mp3, m4p, wav, or ogg files.";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/create";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable long id) throws Exception {
        ModelAndView modelAndView = new ModelAndView("edit");
        MusicForm musicForm = musicService.getByIdMusic(id);
        modelAndView.addObject("musicForm", musicForm);
        return modelAndView;
    }
    @PostMapping("/edit/update")
    public String update(@Valid MusicForm musicForm, BindingResult bindingResult, Model model) throws Exception {
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        }
        boolean isSaveSuccessfully = musicService.save(musicForm);
        String message;
        if (isSaveSuccessfully) {
            message = "Updated song \"" + musicForm.getName() + "\" successfully!";
        } else {
            message = "Update FAIL";
        }
        model.addAttribute("message", message);
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        musicService.delete(id);
        return "redirect:/";
    }
}
