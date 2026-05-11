package com.ecommerce.inventoryservice.kafka;

import com.ecommerce.inventoryservice.dto.OrderCreatedEvent;
import com.ecommerce.inventoryservice.entity.Product;
import com.ecommerce.inventoryservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryConsumer {

    private final ProductRepository productRepository;

    @KafkaListener(topics = "order-topic", groupId = "inventory-group")
    public void consume(OrderCreatedEvent event) {

        if (event == null) {
            System.out.println("Received null event, skipping...");
            return;
        }

        System.out.println("Received order event for productId: " + event.getProductId());

        System.out.println("Updating stock for productId: " + event.getProductId() +
            " with quantity: " + event.getQuantity());


        UUID productId = UUID.fromString(event.getProductId());

        Optional<Product> productOpt = productRepository.findById(productId);

        if (productOpt.isEmpty()) {
            System.out.println("Product not found for ID: " + event.getProductId());
            return;
        }
        
        Product product = productOpt.get();

        product.setStock(product.getStock() - event.getQuantity());

        productRepository.save(product);

        System.out.println("Stock updated successfully for productId: " + event.getProductId());
    }
}