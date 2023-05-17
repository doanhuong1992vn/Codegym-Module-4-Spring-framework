package com.blog_application.controller;

import com.blog_application.entity.Category;
import com.blog_application.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("/create")
    public String create(Category category, HttpSession session) {
        categoryService.save(category);
        session.setAttribute("categories", categoryService.findAll());
        return "redirect:/";
    }
}
