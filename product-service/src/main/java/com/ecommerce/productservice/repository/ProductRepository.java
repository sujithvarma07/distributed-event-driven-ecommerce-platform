package com.ecommerce.productservice.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ecommerce.productservice.entity.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;
public interface ProductRepository extends CassandraRepository<Product, UUID> {

    Page<Product> findAll(Pageable pageable);

}