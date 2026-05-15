package com.orderservice.Service;

import com.orderservice.Model.OrderRequestDto;
import com.orderservice.Reource.OrderResponse;

public interface OrderService {

    public OrderResponse newOrder(OrderRequestDto order);
}
