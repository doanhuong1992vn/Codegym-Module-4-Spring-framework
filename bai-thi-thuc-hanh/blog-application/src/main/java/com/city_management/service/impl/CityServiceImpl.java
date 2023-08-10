package com.city_management.service.impl;

import com.city_management.entity.City;
import com.city_management.entity.Country;
import com.city_management.repository.CityRepository;
import com.city_management.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public void update(City city) {
        cityRepository.save(city);
    }

    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public Page<City> findByCountry(Country country, Pageable pageable) {
        return cityRepository.findAllByCountry(country, pageable);
    }

    @Override
    public Page<City> findAllByNameContaining(String query, Pageable pageRequest) {
        return cityRepository.findAllByNameContaining(query, pageRequest);
    }
}
