package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import service.IConverterService;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@Controller
public class ConverterServlet {
    @Autowired
    private IConverterService converterService;
    @GetMapping("/")
    public ModelAndView getConverterForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("currency", null);
        modelAndView.addObject("rate", 25000);
        return modelAndView;
    }
    @GetMapping("/convert")
    public ModelAndView getResult(@RequestParam double currency, double rate) {
        ModelAndView modelAndView = new ModelAndView("index");
        double result = converterService.getResult(currency, rate);
        modelAndView.addObject("currency", currency);
        modelAndView.addObject("rate", rate);
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}