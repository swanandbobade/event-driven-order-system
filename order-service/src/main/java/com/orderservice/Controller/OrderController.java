package com.orderservice.Controller;

import com.orderservice.Model.OrderRequestDto;
import com.orderservice.Reource.OrderDetailsResponse;
import com.orderservice.Reource.OrderResponse;
import com.orderservice.Service.Impl.OrderServiceImpl;
import com.orderservice.Service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> newOrder(@Valid @RequestBody OrderRequestDto order) {
        return ResponseEntity.ok(orderService.newOrder(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailsResponse> getOrderByID(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<OrderDetailsResponse> cancelOrderByID(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.cancelOrderById(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<OrderDetailsResponse>> viewAllOrderByUserId(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.viewAllOrdersByUserId(id));
    }
}
