package com.orderservice.Client;

import com.orderservice.Model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@FeignClient(
        name = "user-service",
        url = "${external-services.user-service.url}"
)
public interface UserClient {

    //Change according to User service endpoints
    @GetMapping("/user/{id}")
    Optional<UserDto> getUserById(Long userId);
}
