package com.orderservice.Service.Impl;

import com.orderservice.Client.Impl.ExternalClientImpl;
import com.orderservice.Entity.Order;
import com.orderservice.Enum.OrderStatus;
import com.orderservice.Mapper.OrderMapper;
import com.orderservice.Model.OrderCreatedEvent;
import com.orderservice.Model.OrderRequestDto;
import com.orderservice.Model.ProductDto;
import com.orderservice.Producer.OrderProducer;
import com.orderservice.Reource.OrderResponse;
import com.orderservice.Repository.OrderRepository;
import com.orderservice.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ExternalClientImpl client;

    @Autowired
    OrderMapper mapper;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderProducer producer;

    @Override
    public OrderResponse newOrder(OrderRequestDto order) {

        ProductDto product = client.getProductById(order.getProductId())
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        Order entity = mapper.toEntity(order);

        entity.setProductName(product.getProductName());
        entity.setProductPrice(product.getProductPrice());
        entity.setTotalAmount(
                product.getProductPrice() * order.getQuantity()
        );
        entity.setStatus(OrderStatus.CREATED);

        //DB
        Order savedOrder = orderRepository.save(entity);

        OrderCreatedEvent event = OrderCreatedEvent.builder()
                .orderId(savedOrder.getOrderId())
                .userId(savedOrder.getUserId())
                .productId(savedOrder.getProductId())
                .quantity(savedOrder.getQuantity())
                .totalAmount(savedOrder.getTotalAmount())
                .build();

        producer.publishOrderCreatedEvent(event);

        return mapper.toResponse(savedOrder);
    }
}
