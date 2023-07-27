package com.example.core.repository;

import com.example.core.model.OrderTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderTest, Long> {
}
