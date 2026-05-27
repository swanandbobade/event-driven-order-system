package com.orderservice.Client;

import com.orderservice.Model.AddressDto;
import com.orderservice.Model.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@FeignClient(
        name = "address-service",
        url = "${external-services.address-service.url}"
)
public interface AddressClient {
    //Change according to Address service endpoints
    @GetMapping("/products/{id}")
    Optional<AddressDto> getAddressById(Long addressID);
}
