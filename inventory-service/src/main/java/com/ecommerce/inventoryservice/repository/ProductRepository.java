package com.ecommerce.inventoryservice.repository;

import com.ecommerce.inventoryservice.entity.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {
}