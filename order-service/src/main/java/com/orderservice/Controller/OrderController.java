package com.orderservice.Controller;

import com.orderservice.Model.OrderRequestDto;
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
    private OrderServiceImpl orderService;

    //Place order
    @PostMapping
    public ResponseEntity<OrderResponse> newOrder(@Valid @RequestBody OrderRequestDto order) {
        return ResponseEntity.ok(orderService.newOrder(order));
    }

    //View order by id
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderByID(@RequestParam Integer id) {
        return null;
    }

    //Cancel order
    @GetMapping("/cancel/{id}")
    public ResponseEntity<OrderResponse> cancelOrderByID(@RequestParam Integer id) {
        return null;
    }

    //view orders
    @GetMapping("/user/{id}")
    public ResponseEntity<List<OrderResponse>> viewAllOrderByUserId(@RequestParam Integer id) {
        return null;
    }
}
