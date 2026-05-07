package com.ecommerce.orderservice.controller;

import com.ecommerce.orderservice.entity.Order;
import com.ecommerce.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController{

    private final OrderService orderService;

    @PostMapping
    public Order create(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
}