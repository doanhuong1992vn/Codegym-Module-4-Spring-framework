package com.picture_of_day.controller;

import com.picture_of_day.model.Comment;
import com.picture_of_day.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    private final CommentService commentService;

    public MainController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("comment", new Comment());
        List<Comment> comments = commentService.getAll();
        model.addAttribute("comments", comments);
        return "index";
    }

    @PostMapping("/create")
    public String create(Comment comment) {
        commentService.save(comment);
        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable long id) {
        commentService.setLike(id);
        return "redirect:/";
    }
}
