package com.save_email_configs_app.controller;

import com.save_email_configs_app.model.EmailConfig;
import com.save_email_configs_app.model.Languages;
import com.save_email_configs_app.service.EmailConfigsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
public class EmailConfigsController {
    @Autowired
    private EmailConfigsService emailConfigsService;
    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("emailConfigs", EmailConfig.getInstance());
        return modelAndView;
    }
     @GetMapping("edit")
    public ModelAndView edit(){
         ModelAndView modelAndView = new ModelAndView("edit");
         modelAndView.addObject("emailConfigs", EmailConfig.getInstance());
         modelAndView.addObject("languages", Arrays.stream(Languages.values()).toList());
         return modelAndView;
     }
     @PostMapping("update")
    public String save(EmailConfig emailConfig) {
         emailConfigsService.saveConfigs(emailConfig);
         return "redirect:/";
     }
}
