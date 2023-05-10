package com.music_upload.controller;

import com.music_upload.model.Music;
import com.music_upload.model.MusicForm;
import com.music_upload.model.MusicGenres;
import com.music_upload.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Controller
@PropertySource("classpath:upload_music.properties")
public class MusicController {
    @Value("${music-upload}")
    private String musicUpload;
    @Autowired
    private MusicService musicService;

    @GetMapping({"", "/"})
    public String index(Model model) {
        List<Music> musicList = musicService.getAll();
        model.addAttribute("musicList", musicList);
        return "index";
    }
    @GetMapping("create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("musicForm", new MusicForm());
        modelAndView.addObject("musicGenres", Arrays.stream(MusicGenres.values()).toList());
        return modelAndView;
    }

    @PostMapping("save")
    public String save(MusicForm musicForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = musicForm.getUrl();
        String fileName = multipartFile.getOriginalFilename();
        System.out.println(fileName);
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(musicUpload + fileName));
        } catch (Exception e) {
            System.out.println("Lỗi copy file");
            e.printStackTrace();
        }
        musicService.save(musicForm, fileName);
        String message = "Created " + musicForm.getName() + " successfully!";
        redirectAttributes.addFlashAttribute("message",message);
        return "redirect:/create";
    }
}
