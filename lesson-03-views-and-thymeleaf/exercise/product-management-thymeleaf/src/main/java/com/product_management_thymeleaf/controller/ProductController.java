package com.product_management_thymeleaf.controller;

import com.product_management_thymeleaf.model.domain.Product;
import com.product_management_thymeleaf.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = {"/", "/products"})
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/")
    public ModelAndView homepage(){
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> products = productService.getAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }
    @RequestMapping("create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
    @PostMapping("save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
         productService.save(product);
         redirectAttributes.addFlashAttribute("message", "Create product successfully!");
         return "redirect:/";
    }

}
