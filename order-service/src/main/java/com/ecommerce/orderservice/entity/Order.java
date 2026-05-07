package com.ecommerce.orderservice.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.UUID;

@Table("orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @PrimaryKey
    private UUID id;

    private String userId;
    private String productId;
    private int quantity;
}