package com.orderservice.Connector.Impl;

import com.orderservice.Client.ProductClient;
import com.orderservice.Connector.ProductConnector;
import com.orderservice.Model.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ProductConnectorImpl implements ProductConnector {

    private final ProductClient client;

    @Override
    public Optional<ProductDto> getProductById(Long productId) {
//        try {
//            return client.getProductById(productId);
//        } catch (Exception ex) {
//            return Optional.empty();
//        }

        ProductDto product = ProductDto.builder()
                .productId(productId)
                .productName("iPhone 15")
                .productPrice(76000.0)
                .quantity(10)
                .build();

        return Optional.of(product);
    }
}
