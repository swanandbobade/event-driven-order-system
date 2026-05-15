package com.orderservice.Model;

import lombok.Data;

@Data
public class ProductDto {

    private Long productId;

    private String productName;

    private Double productPrice;

    private Integer quantity;

    private Double totalAmount;
}
