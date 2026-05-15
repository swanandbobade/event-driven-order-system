package com.orderservice.Entity;

import com.orderservice.Enum.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long userId;

    private Long productId;

    private String productName;

    private Double productPrice;

    private Integer quantity;

    private Double totalAmount;

    private Long addressId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @CreationTimestamp
    private LocalDateTime createdDate;
}
