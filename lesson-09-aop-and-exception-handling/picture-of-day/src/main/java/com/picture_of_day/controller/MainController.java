package com.picture_of_day.controller;

import com.picture_of_day.model.Comment;
import com.picture_of_day.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final CommentService commentService;

    @GetMapping
    public ModelAndView index(@PageableDefault(size = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("comment", new Comment());
        Sort sort = Sort.by("likes").descending()
                .and(Sort.by("postTime").descending());
        Pageable pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        Page<Comment> comments = commentService.findByPostTimeInDay(pageRequest);
        modelAndView.addObject("comments", comments);
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Comment comment, HttpServletRequest request) {
        commentService.save(comment);
        String referer = request.getHeader("referer");
        return "redirect:" + referer;
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable long id, HttpServletRequest request) {
        commentService.setLike(id);
        String referer = request.getHeader("referer");
        return "redirect:" + referer;
    }
}
