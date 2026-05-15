package com.orderservice.Client.Impl;

import com.orderservice.Client.ExternalClient;
import com.orderservice.Model.ProductDto;

import java.util.Optional;

public class ExternalClientImpl implements ExternalClient {

    @Override
    public Optional<ProductDto> getProductById(Long productId) {
        return null;
    }
}
