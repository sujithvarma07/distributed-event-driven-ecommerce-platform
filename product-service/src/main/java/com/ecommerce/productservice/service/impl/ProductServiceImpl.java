package com.ecommerce.productservice.service.impl;
import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.repository.ProductRepository;
import com.ecommerce.productservice.service.ProductService;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product create(Product product) {

        product.setId(UUID.randomUUID());
        return productRepository.save(product);
    }

    @Override
    @Cacheable(value = "products", key = "#page + '-' + #size") // Cache results based on page and size to avoid redundant DB calls
    public List<Product> getAll(int page, int size) {
        System.out.println("Fetching products using Cassandra optimized pagination (Slice)...");
        Slice<Product> products = productRepository.findAll(PageRequest.of(page, size));
        return products.getContent();
    }
}