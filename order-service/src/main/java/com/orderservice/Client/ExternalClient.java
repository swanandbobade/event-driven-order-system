package com.orderservice.Client;

import com.orderservice.Model.ProductDto;

import java.util.Optional;

public interface ExternalClient {

    Optional<ProductDto> getProductById(Long productId);
}
