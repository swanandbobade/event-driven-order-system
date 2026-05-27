package com.orderservice.Connector;

import com.orderservice.Model.ProductDto;
import com.orderservice.Model.UserDto;

import java.util.Optional;

public interface UserConnector {
    Optional<UserDto> getUserById(Long userId);
}
