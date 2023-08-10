package com.city_management.repository;

import com.city_management.entity.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

}
