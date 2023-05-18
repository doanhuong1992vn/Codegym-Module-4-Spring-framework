package com.blog_application.controller;

import com.blog_application.entity.Category;
import com.blog_application.entity.Post;
import com.blog_application.service.CategoryService;
import com.blog_application.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final PostService postService;

    @PostMapping("/create")
    public String create(String nameCategory, HttpServletRequest request) {
        categoryService.save(new Category(nameCategory));
        request.getSession().setAttribute("categories", categoryService.findAll());
        String referrer = request.getHeader("referer");
        return "redirect:" + referrer;
    }

    @GetMapping("/{id}/posts")
    public ModelAndView showPosts(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        return category.map(value -> {
                    ModelAndView modelAndView = new ModelAndView("index");
                    Iterable<Post> postList = postService.findAllByCategory(value);
                    modelAndView.addObject( "postList", postList);
                    String nameCategory = "Danh mục " + value.getName() + ":";
                    modelAndView.addObject("nameCategory", nameCategory);
                    return modelAndView;
                })
                .orElseGet(() -> new ModelAndView("404"));
    }
}
