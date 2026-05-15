package com.orderservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCreatedEvent {

    private Long orderId;

    private Long userId;

    private Long productId;

    private Integer quantity;

    private Double totalAmount;
}
