package com.orderservice.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

    private Long productId;

    private String productName;

    private Double productPrice;

    private Integer quantity;

}
