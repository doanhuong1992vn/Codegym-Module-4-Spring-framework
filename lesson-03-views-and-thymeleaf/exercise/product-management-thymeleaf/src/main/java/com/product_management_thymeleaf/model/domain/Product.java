package com.product_management_thymeleaf.model.domain;

public class Product {
    private static long count = 0;
    private long id;
    private String name;
    private double price;
    private String description;
    private String producer;

    public Product() {
        this.id = ++count;
    }

    public Product(String name, double price, String description, String producer) {
        this.id = ++count;
        this.name = name;
        this.price = price;
        this.description = description;
        this.producer = producer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
