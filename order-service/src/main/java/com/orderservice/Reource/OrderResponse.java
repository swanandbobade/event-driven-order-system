package com.orderservice.Reource;

import com.orderservice.Enum.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderResponse {
    private Integer orderId;
    private OrderStatus orderStatus;
}
