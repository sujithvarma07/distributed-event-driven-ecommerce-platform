package com.ecommerce.productservice.controller;

import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.service.ProductService;
import org.springframework.data.domain.Page;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product create(@RequestBody Product product) {

        return productService.create(product);
    }

    @GetMapping
    public Page<Product> getAll(
            @RequestParam int page,
            @RequestParam int size) {

        return productService.getAll(page, size);
    }
}