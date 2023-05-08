package com.product_management_thymeleaf.model.service.impl;

import com.product_management_thymeleaf.model.domain.Product;
import com.product_management_thymeleaf.model.service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    private static final List<Product> products = new ArrayList<>();
    static {
        products.add(new Product("Quần", 100000, "Jeans", "Chợ Hạnh Thông Tây"));
        products.add(new Product("Áo", 50000, "Vải lụa", "Chợ Kim Biên"));
        products.add(new Product("Mũ", 70000, "Capback", "Chợ Bà Chiểu"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }
}
