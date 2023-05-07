package com.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @RequestMapping
    public String home(){
        return "index";
    }
    @RequestMapping("/save")
    public ModelAndView save(String[] condiments) {
        ModelAndView modelAndView = new ModelAndView("condiments");
        modelAndView.addObject("condiments", condiments);
        return modelAndView;
    }
}
