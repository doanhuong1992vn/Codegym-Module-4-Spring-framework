package com.product_management_thymeleaf.controller;

import com.product_management_thymeleaf.model.domain.Product;
import com.product_management_thymeleaf.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = {"/", "/products"})
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping(value = {"/", ""})
    public ModelAndView homepage(){
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> products = productService.getAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }
    @RequestMapping("create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("action", "create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
    @PostMapping("create")
    public String save(Product product, RedirectAttributes redirectAttributes) {
         productService.save(product);
         String message = "Create product " + product.getName() + " successfully!";
         redirectAttributes.addFlashAttribute("message", message);
         return "redirect:/";
    }
    @GetMapping("{id}/edit")
    public ModelAndView edit(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("action", "update");
        Product product = productService.getById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    @PostMapping("{id}/update")//không hiểu tại sao trong url ở đây lại có {id}???
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        String message = "Update product " + product.getName() + " successfully!";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }
    @GetMapping("{id}/delete")
    public ModelAndView delete(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("action", "delete");
        Product product = productService.getById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    @PostMapping("{id}/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        String message = "Delete product " + product.getName() + " successfully!";
        redirectAttributes.addFlashAttribute("message", message);
        productService.delete(product);
        return "redirect:/";
    }

    @GetMapping("{id}/view")
    public ModelAndView view(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("action", "view");
        Product product = productService.getById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    @GetMapping("/search")
    public ModelAndView search(String search) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> products = productService.search(search);
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}
