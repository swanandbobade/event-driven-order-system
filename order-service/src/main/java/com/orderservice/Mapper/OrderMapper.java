package com.orderservice.Mapper;

import com.orderservice.Entity.Order;
import com.orderservice.Model.OrderRequestDto;
import com.orderservice.Reource.OrderDetailsResponse;
import com.orderservice.Reource.OrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toEntity(OrderRequestDto dto);

    OrderResponse toResponse(Order order);

    OrderDetailsResponse toOrderDetailsResponse (Order order);
}
