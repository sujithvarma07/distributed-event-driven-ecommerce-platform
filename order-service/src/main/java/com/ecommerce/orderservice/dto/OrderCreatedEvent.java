package com.ecommerce.orderservice.dto;

import java.io.Serializable;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreatedEvent implements Serializable{

    private String orderId;
    private String userId;
    private String productId;
    private int quantity;
}