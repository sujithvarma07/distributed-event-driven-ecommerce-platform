package com.ecommerce.productservice.service;

import com.ecommerce.productservice.entity.Product;

import java.util.List;



public interface ProductService {

    Product create(Product product);

    List<Product> getAll(int page, int size);

}