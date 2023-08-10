package com.city_management.service.impl;

import com.city_management.entity.Country;
import com.city_management.repository.CountryRepository;
import com.city_management.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }


    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }


    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public void update(Country country) {
        countryRepository.save(country);
    }

}
