package com.orderservice.Client;

import com.orderservice.Model.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
@FeignClient(
        name = "product-service",
        url = "${external-services.product-service.url}"
)
public interface ProductClient {

    //Change according to Product service endpoints
    @GetMapping("/product/{id}")
    Optional<ProductDto> getProductById(@PathVariable("id") Long productId);
}
