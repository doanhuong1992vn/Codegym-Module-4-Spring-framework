package com.blog_application.controller;

import com.blog_application.entity.Post;
import com.blog_application.service.CategoryService;
import com.blog_application.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final CategoryService categoryService;
    private final PostService postService;

    @GetMapping
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Post> postList = postService.findAll();
        modelAndView.addObject("postList", postList);
        request.getSession().setAttribute("categories", categoryService.findAll());
        return modelAndView;
    }
}
