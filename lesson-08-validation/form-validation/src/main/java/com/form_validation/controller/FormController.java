package com.form_validation.controller;

import com.form_validation.entity.User;
import com.form_validation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class FormController {
    private final UserService userService;

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index", "user", new User());
    }

    @PostMapping("/validate")
    public String validate(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "index";
        }
        return "success";
    }
}
