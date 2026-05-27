package com.orderservice.Service.Impl;

import com.orderservice.Connector.AddressConnector;
import com.orderservice.Connector.ProductConnector;
import com.orderservice.Connector.UserConnector;
import com.orderservice.Entity.Order;
import com.orderservice.Enum.OrderStatus;
import com.orderservice.Mapper.OrderMapper;
import com.orderservice.Model.*;
import com.orderservice.Producer.OrderProducer;
import com.orderservice.Reource.OrderDetailsResponse;
import com.orderservice.Reource.OrderResponse;
import com.orderservice.Repository.OrderRepository;
import com.orderservice.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductConnector productConnector;

    @Autowired
    AddressConnector addressConnector;

    @Autowired
    UserConnector userConnector;

    @Autowired
    OrderMapper mapper;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderProducer producer;

    @Override
    public OrderResponse newOrder(OrderRequestDto order) {

        ProductDto product = productConnector.getProductById(order.getProductId())
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        UserDto user = userConnector.getUserById(order.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        AddressDto address = addressConnector
                .getAddressById(order.getAddressId())
                .orElseThrow(() ->
                        new RuntimeException("Address not found"));

        Order entity = mapper.toEntity(order);

        entity.setUserId(user.getUserId());
        entity.setAddressId(address.getAddressId());
        entity.setProductName(product.getProductName());
        entity.setProductPrice(product.getProductPrice());
        entity.setTotalAmount(
                product.getProductPrice() * order.getQuantity()
        );
        entity.setStatus(OrderStatus.CREATED);

        Order savedOrder = orderRepository.save(entity);

        OrderEvent event = OrderEvent.builder()
                .orderId(savedOrder.getOrderId())
                .userId(savedOrder.getUserId())
                .addressId(savedOrder.getAddressId())
                .productId(savedOrder.getProductId())
                .quantity(savedOrder.getQuantity())
                .totalAmount(savedOrder.getTotalAmount())
                .status(savedOrder.getStatus())
                .build();

        //producer.publishOrderEvent(event);

        return mapper.toResponse(savedOrder);
    }

    @Override
    public OrderDetailsResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));

        return mapper.toOrderDetailsResponse(order);
    }

    @Override
    public OrderDetailsResponse cancelOrderById(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));

        if (order.getStatus() == OrderStatus.CANCELLED) {
            throw new RuntimeException("Order already cancelled");
        }

        order.setStatus(OrderStatus.CANCELLED);
        Order updatedOrder = orderRepository.save(order);

        OrderEvent event = OrderEvent.builder()
                .orderId(updatedOrder.getOrderId())
                .userId(updatedOrder.getUserId())
                .addressId(updatedOrder.getAddressId())
                .productId(updatedOrder.getProductId())
                .quantity(updatedOrder.getQuantity())
                .totalAmount(updatedOrder.getTotalAmount())
                .status(OrderStatus.CANCELLED)
                .build();

       // producer.publishOrderEvent(event);

        return mapper.toOrderDetailsResponse(updatedOrder);
    }

    @Override
    public List<OrderDetailsResponse> viewAllOrdersByUserId(Long id) {

        List<Order> orders = orderRepository.findByUserId(id);

        if (orders == null) {
            throw new RuntimeException("No orders found for user id: " + id);
        }

        return orders.stream()
                .map(mapper::toOrderDetailsResponse)
                .toList();
    }
}
