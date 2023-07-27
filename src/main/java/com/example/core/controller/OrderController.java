package com.example.core.controller;

import com.example.core.model.OrderTest;

import com.example.core.model.Product;
import com.example.core.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderTest>> getAllOrders() {
        List<OrderTest> orders = orderService.getAllOrders();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orders);
    }

    @PostMapping
    public ResponseEntity<OrderTest> saveOrder(@RequestBody OrderTest orderbody) {
        OrderTest order = orderService.saveOrder(orderbody);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(order);
    }
}
