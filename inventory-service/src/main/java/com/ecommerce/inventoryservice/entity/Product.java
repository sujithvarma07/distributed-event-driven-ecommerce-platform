package com.ecommerce.inventoryservice.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.*;

import java.io.Serializable;
import java.util.UUID;

@Table("products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @PrimaryKey
    private UUID id;

    private String name;
    private String description;
    private double price;
    private int stock;
}