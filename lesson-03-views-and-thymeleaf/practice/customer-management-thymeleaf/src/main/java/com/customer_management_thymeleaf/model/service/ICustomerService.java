package com.customer_management_thymeleaf.model.service;

import com.customer_management_thymeleaf.model.domain.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
