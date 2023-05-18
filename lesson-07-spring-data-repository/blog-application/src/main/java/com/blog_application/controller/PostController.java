package com.blog_application.controller;

import com.blog_application.entity.Category;
import com.blog_application.entity.Post;
import com.blog_application.service.CategoryService;
import com.blog_application.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
@SessionAttributes("categories")
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
        if (post.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("categoryList", categoryService.findAll());
            modelAndView.addObject("blog", post.get());
            return modelAndView;
        } else {
            return new ModelAndView("404");
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Post post) {
        postService.update(post);
        return "redirect:/post/view/" + post.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        postService.delete(id);
        return "redirect:/";
    }

    @ModelAttribute("categories")
    public Iterable<Category> getCategories(HttpServletRequest request) {
        Iterable<Category> categories = (Iterable<Category>) request.getSession().getAttribute("categories");
        if (categories == null) {
            return categoryService.findAll();
        } else {
            return categories;
        }
    }
}
