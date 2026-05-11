package com.ecommerce.orderservice.kafka;

import com.ecommerce.orderservice.dto.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    private static final String TOPIC = "order-topic";

    public void sendOrderEvent(OrderCreatedEvent event) {

        System.out.println("Publishing order event to Kafka for orderId: " + event.getOrderId());

        kafkaTemplate.send(TOPIC, event);

    }
}