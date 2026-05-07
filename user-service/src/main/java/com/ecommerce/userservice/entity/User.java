package com.ecommerce.userservice.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.*;
import java.util.UUID;

@Table("users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @PrimaryKey
    private UUID id;

    private String email;
    private String password;
    private String role;

}