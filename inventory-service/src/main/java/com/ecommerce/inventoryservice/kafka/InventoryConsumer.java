package com.ecommerce.inventoryservice.kafka;

import com.ecommerce.inventoryservice.dto.OrderCreatedEvent;
import com.ecommerce.inventoryservice.entity.Product;
import com.ecommerce.inventoryservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InventoryConsumer {

    private final ProductRepository productRepository;

    @KafkaListener(topics = "order-topic", groupId = "inventory-group")
    public void consume(OrderCreatedEvent event) {

        System.out.println("Received order event: " + event);

        UUID productId = UUID.fromString(event.getProductId());

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setStock(product.getStock() - event.getQuantity());

        productRepository.save(product);

        System.out.println("Stock updated!");
    }
}