package com.productservice.Model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {

    @NotBlank(message = "Product name cannot be empty!")
    private String productName;

    @NotBlank(message = "Category cannot be empty!")
    private String category;

    @DecimalMin(value = "1.0", message = "Price should be at least 1")
    @NotNull(message = "Price cannot be empty!")
    private Double productPrice;

    @Min(value = 0, message = "Quantity cannot be less than ZERO")
    @NotNull
    private Integer quantity;

}
