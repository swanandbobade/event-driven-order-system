package com.orderservice.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
    @NotNull(message = "User ID cannot be null")
    private Long userId;
    @NotNull(message = "Product ID cannot be null")
    private Long productId;
    @NotNull
    @Min(value = 1, message = "Quantity should be at least 1")
    @Max(value = 2, message = "Order quantity cannot exceed more than 2 units")
    private Integer quantity;
    @NotNull(message = "Address cannot be null")
    private Long addressId;
}
