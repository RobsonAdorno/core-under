package com.example.core.service;

import com.example.core.model.modelRedundant.OrderTest;
import com.example.core.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private IOrderRepository iOrderRepository;

    public OrderTest saveOrder(OrderTest order) {
        return iOrderRepository.save(order);
    }

    public OrderTest getOrderById(Long id) {
        return iOrderRepository.findById(id).orElseThrow();
    }

    public List<OrderTest> getAllOrders() {
        return iOrderRepository.findAll();
    }
}
