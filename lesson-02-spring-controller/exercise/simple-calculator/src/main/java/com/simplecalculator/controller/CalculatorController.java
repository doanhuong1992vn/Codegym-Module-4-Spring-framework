package com.simplecalculator.controller;

import com.simplecalculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;
    @RequestMapping
    public String getCalculatorForm() {
        return "index";
    }
    @RequestMapping("/calculator")
    public ModelAndView calculate(@RequestParam double firstOperand, double secondOperand, String operator) {
        ModelAndView modelAndView = new ModelAndView("index");
        StringBuilder result = calculatorService.calculate(firstOperand, secondOperand, operator);
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}
