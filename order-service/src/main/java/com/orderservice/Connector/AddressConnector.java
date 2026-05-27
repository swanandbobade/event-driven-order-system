package com.orderservice.Connector;

import com.orderservice.Model.AddressDto;

import java.util.Optional;

public interface AddressConnector {
    Optional<AddressDto> getAddressById(Long addressId);
}
