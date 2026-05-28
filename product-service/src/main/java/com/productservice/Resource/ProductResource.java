package com.productservice.Resource;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResource {

    private Long productId;
    private String productName;
    private String category;
    private Double productPrice;
    private Integer quantity;
}
