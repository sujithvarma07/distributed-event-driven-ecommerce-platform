package com.ecommerce.userservice.service;

import com.ecommerce.userservice.dto.*;

public interface UserService {

    String register(RegisterRequest request);

    String login(LoginRequest request);
}