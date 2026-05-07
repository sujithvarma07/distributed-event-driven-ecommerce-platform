package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.entity.Order;

public interface OrderService {

    Order createOrder(Order order);
}