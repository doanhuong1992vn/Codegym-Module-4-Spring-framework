package com.city_management.repository;

import com.city_management.entity.City;
import com.city_management.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    Page<City> findAllByCountry(Country country, Pageable pageable);

    Page<City> findAllByNameContaining(String query, Pageable pageable);

}
