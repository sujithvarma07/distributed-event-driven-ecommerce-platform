package com.ecommerce.inventoryservice.dto;

import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedEvent implements Serializable {

    private String orderId;
    private String userId;
    private String productId;
    private int quantity;
}