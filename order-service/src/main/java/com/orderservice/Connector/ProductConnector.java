package com.orderservice.Connector;

import com.orderservice.Model.ProductDto;

import java.util.Optional;

public interface ProductConnector {
    public Optional<ProductDto> getProductById(Long productId);
}
