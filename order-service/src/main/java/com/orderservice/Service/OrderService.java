package com.orderservice.Service;

import com.orderservice.Model.OrderRequestDto;
import com.orderservice.Reource.OrderDetailsResponse;
import com.orderservice.Reource.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse newOrder(OrderRequestDto order);

    OrderDetailsResponse getOrderById(Long id);

    OrderDetailsResponse cancelOrderById(Long id);

    List<OrderDetailsResponse> viewAllOrdersByUserId(Long id);
}
