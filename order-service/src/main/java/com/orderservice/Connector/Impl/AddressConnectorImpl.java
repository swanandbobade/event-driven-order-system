package com.orderservice.Connector.Impl;

import com.orderservice.Client.AddressClient;
import com.orderservice.Connector.AddressConnector;
import com.orderservice.Model.AddressDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AddressConnectorImpl implements AddressConnector {


    private final AddressClient client;

    @Override
    public Optional<AddressDto> getAddressById(Long addressId) {
//        try {
//            return client.getAddressById(addressId);
//        } catch (Exception ex) {
//            return Optional.empty();
//        }

        AddressDto address = AddressDto.builder()
                .addressId(addressId)
                .streetName("ST Christ")
                .cityName("Pune")
                .stateName("Maharashtra")
                .pinCode(411028)
                .build();

        return Optional.of(address);
    }
}
