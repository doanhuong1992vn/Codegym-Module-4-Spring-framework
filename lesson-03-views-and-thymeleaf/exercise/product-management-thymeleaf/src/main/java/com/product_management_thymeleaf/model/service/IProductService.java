package com.product_management_thymeleaf.model.service;

import com.product_management_thymeleaf.model.domain.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    void save(Product product);
}
