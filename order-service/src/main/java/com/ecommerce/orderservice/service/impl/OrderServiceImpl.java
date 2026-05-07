package com.ecommerce.orderservice.service.impl;

import com.ecommerce.orderservice.dto.OrderCreatedEvent;
import com.ecommerce.orderservice.entity.Order;
import com.ecommerce.orderservice.kafka.OrderProducer;
import com.ecommerce.orderservice.repository.OrderRepository;
import com.ecommerce.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderProducer orderProducer;

    @Override
    public Order createOrder(Order order) {

        order.setId(UUID.randomUUID());
        Order savedOrder = orderRepository.save(order);

        // 🔥 Send event to Kafka
        OrderCreatedEvent event = new OrderCreatedEvent(
                savedOrder.getId().toString(),
                savedOrder.getUserId(),
                savedOrder.getProductId(),
                savedOrder.getQuantity()
        );

        orderProducer.sendOrderEvent(event);

        return savedOrder;
    }
}