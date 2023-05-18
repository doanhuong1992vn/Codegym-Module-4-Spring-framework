package com.blog_application.controller;

import com.blog_application.entity.Category;
import com.blog_application.entity.Post;
import com.blog_application.service.CategoryService;
import com.blog_application.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@SessionAttributes("categories")
public class HomeController {
    private final CategoryService categoryService;
    private final PostService postService;

    @GetMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Post> postList = postService.findAll();
        modelAndView.addObject("postList", postList);
        return modelAndView;
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
