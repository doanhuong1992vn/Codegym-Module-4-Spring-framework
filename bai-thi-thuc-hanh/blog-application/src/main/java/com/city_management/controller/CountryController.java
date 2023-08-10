package com.city_management.controller;

import com.city_management.entity.Country;
import com.city_management.entity.City;
import com.city_management.service.CountryService;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;
    private final CityService cityService;

    @PostMapping("/create")
    public String create(String nameCountry, HttpServletRequest request) {
        countryService.save(new Country(nameCountry));
        request.getSession().setAttribute("countries", countryService.findAll());
        String referer = request.getHeader("referer");
        return "redirect:" + referer;
    }

    @GetMapping("/view/{id}/cities")
    public ModelAndView view(@PathVariable Long id, @PageableDefault(size = 3) Pageable pageable) {
        Optional<Country> country = countryService.findById(id);
        return country.map(value -> {
                    ModelAndView modelAndView = new ModelAndView("cities-by-country");
                    Pageable pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
                    Page<City> cities = cityService.findByCountry(value, pageRequest);
                    modelAndView.addObject("cities", cities);
                    modelAndView.addObject("country", value);
                    return modelAndView;
                })
                .orElseGet(() -> new ModelAndView("404"));
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        Optional<Country> country = countryService.findById(id);
        return country.map(value -> new ModelAndView("country", "country", value))
                .orElseGet(() -> new ModelAndView("404"));
    }

    @PostMapping("/update")
    public String update(Country country, HttpSession session) {
        countryService.update(country);
        session.setAttribute("countries", countryService.findAll());
        return "redirect:/country/edit/" + country.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        countryService.delete(id);
        return "redirect:/";
    }
}
