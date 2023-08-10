package com.city_management.controller;

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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final CountryService countryService;
    private final CityService cityService;

    @GetMapping
    public ModelAndView index(HttpSession session,@PageableDefault(size=3) Pageable pageable) {
        session.setAttribute("countries", countryService.findAll());
        Pageable pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<City> cities = cityService.findAll(pageRequest);
        return new ModelAndView("index", "cities", cities);
    }
}
