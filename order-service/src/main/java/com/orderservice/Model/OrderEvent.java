package com.orderservice.Model;

import com.orderservice.Enum.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEvent {

    private Long orderId;

    private Long userId;

    private Long productId;

    private Long addressId;

    private Integer quantity;

    private Double totalAmount;

    private OrderStatus status;
}
