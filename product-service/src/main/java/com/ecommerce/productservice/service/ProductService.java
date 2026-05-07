package com.ecommerce.productservice.service;

import com.ecommerce.productservice.entity.Product;
import org.springframework.data.domain.Page;

public interface ProductService {

    Product create(Product product);

   Page<Product> getAll(int page, int size);

}