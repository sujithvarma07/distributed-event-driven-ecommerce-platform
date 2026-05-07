package com.ecommerce.orderservice.repository;

import com.ecommerce.orderservice.entity.Order;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface OrderRepository extends CassandraRepository<Order, UUID> {
}