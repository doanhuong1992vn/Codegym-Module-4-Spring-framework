package com.product_management_thymeleaf.model.service.impl;

import com.product_management_thymeleaf.model.domain.Product;
import com.product_management_thymeleaf.model.service.IProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        Product originProduct = getById(product.getId());
        if (originProduct == null) {
            products.add(product);
        } else {
            originProduct.setName(product.getName());
            originProduct.setPrice(product.getPrice());
            originProduct.setDescription(product.getDescription());
            originProduct.setProducer(product.getProducer());
        }
    }

    @Override
    public Product getById(long id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void delete(Product product) {
        products.remove(getById(product.getId()));
        /*
        phải dùng getById() vì product param có địa chỉ tham chiếu khác với product ban đầu trong products.
        tuy cùng thuộc tính và id nhưng nó chỉ giống như 1 bản clone của product trong products.
        lý do: sau khi truyền product từ controller qua view rồi nhận lại product từ view thì
        product trả về không có cùng địa chỉ tham chiếu với product truyền đi ban đầu nữa.
         */

    }

    @Override
    public List<Product> search(String search) {
        return products.stream()
                .filter(product -> product.getName().toUpperCase()
                                .contains(search.toUpperCase()))
                .collect(Collectors.toList());
    }
}
