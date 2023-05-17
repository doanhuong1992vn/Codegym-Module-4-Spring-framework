package com.blog_application.controller;

import com.blog_application.entity.Post;
import com.blog_application.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("create", "post", new Post());
    }

    @PostMapping("/save")
    public String save(Post post, RedirectAttributes redirectAttributes) {
        postService.save(post);
        String message = "Created " + post.getTitle() + " successfully!";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/post/create";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        if (post.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("info");
            modelAndView.addObject("post", post.get());
            return modelAndView;
        } else {
            return new ModelAndView("404");
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        return post.map(value -> new ModelAndView("edit", "post", value))
                .orElseGet(() -> new ModelAndView("404"));
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        postService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(Post post) {
        postService.update(post);
        return "redirect:/view/" + post.getId();
    }
}
