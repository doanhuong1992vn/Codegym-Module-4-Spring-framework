package com.city_management.service;

import com.city_management.entity.City;
import com.city_management.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService extends GeneralService<City> {
    Page<City> findAll(Pageable pageable);

    Page<City> findByCountry(Country value, Pageable pageable);

    Page<City> findAllByNameContaining(String query, Pageable pageRequest);
}
