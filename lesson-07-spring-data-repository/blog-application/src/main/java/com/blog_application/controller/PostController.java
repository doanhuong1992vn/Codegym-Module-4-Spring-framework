package com.blog_application.controller;

import com.blog_application.entity.Post;
import com.blog_application.service.CategoryService;
import com.blog_application.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    private final CategoryService categoryService;

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
        return post.map(value -> new ModelAndView("info", "post", value))
                .orElseGet(() -> new ModelAndView("404"));
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        return post.map(value -> new ModelAndView("edit", "post", value))
                .orElseGet(() -> new ModelAndView("404"));
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("post") Post post) {
        postService.update(post);
        return "redirect:/post/view/" + post.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        postService.delete(id);
        return "redirect:/";
    }
}
