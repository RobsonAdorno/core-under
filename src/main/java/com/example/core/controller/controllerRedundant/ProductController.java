package com.example.core.controller.controllerRedundant;

import com.example.core.model.modelRedundant.Product;

import com.example.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(products);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(product);
    }

    @PostMapping
    public ResponseEntity<Product> saveOnlyOnceProduct(@RequestBody Product productParam) {
        Product product = productService.saveProduct(productParam);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(product);
    }
}
