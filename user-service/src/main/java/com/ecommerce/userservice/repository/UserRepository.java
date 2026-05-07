package com.ecommerce.userservice.repository;

import com.ecommerce.userservice.entity.User;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CassandraRepository<User, UUID> {

    Optional<User> findByEmail(String email);

}