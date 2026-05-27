package com.orderservice.Reource;

import com.orderservice.Enum.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsResponse {

    private Long orderId;

    private Long userId;

    private Long productId;

    private String productName;

    private Double productPrice;

    private Integer quantity;

    private Double totalAmount;

    private Long addressId;

    private OrderStatus status;

    private LocalDateTime createdDate;
}