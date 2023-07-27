package com.example.core.service;

import com.example.core.model.Product;
import com.example.core.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private IProductRepository iProductRepository;

    public List<Product> getAllProducts() {
        return iProductRepository.findAll();
    }
}
