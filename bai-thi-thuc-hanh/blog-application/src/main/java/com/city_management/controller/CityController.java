package com.city_management.controller;

import com.city_management.entity.City;
import com.city_management.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("create", "city", new City());
    }

    @PostMapping("/save")
    public String save(City city, RedirectAttributes redirectAttributes) {
        cityService.save(city);
        String message = "Add " + city.getName() + " successfully!";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/city/create";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        return city.map(value -> new ModelAndView("info", "city", value))
                .orElseGet(() -> new ModelAndView("404"));
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        return city.map(value -> new ModelAndView("edit", "city", value))
                .orElseGet(() -> new ModelAndView("404"));
    }

    @PostMapping("/update")
    public String update(City city) {
        cityService.update(city);
        return "redirect:/city/view/" + city.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        cityService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public ModelAndView search(String query, @PageableDefault(size = 3) Pageable pageable) {
        Pageable pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<City> cities = cityService.findAllByNameContaining(query, pageRequest);
        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("query", query);
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }
}
