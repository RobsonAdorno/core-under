package com.example.core.repository;

import com.example.core.model.modelRedundant.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT id FROM Product p WHERE p.description = ?1", nativeQuery = true)
    public Long getProductIdByName(String productName);

    @Query(value = "select * from Product p where p.id = ?1", nativeQuery = true)
    Product getProductById(Long id);
}
