package com.orderservice.Connector.Impl;

import com.orderservice.Client.UserClient;
import com.orderservice.Connector.UserConnector;
import com.orderservice.Model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserConnectorImpl implements UserConnector {

    private final UserClient client;

    @Override
    public Optional<UserDto> getUserById(Long userId) {
//        try {
//            return client.getUserById(userId);
//        } catch (Exception ex) {
//            return Optional.empty();
//        }

        UserDto user = UserDto.builder()
                .userId(userId)
                .name("John")
                .emailId("John@hotmail.com")
                .build();

        return Optional.of(user);
    }
}
