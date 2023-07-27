package com.example.core.model;

import com.example.core.model.modelRedundant.OrderTest;
import com.example.core.model.modelRedundant.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 11)
    private int quantity;

    @OneToOne()
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ordertest_id", referencedColumnName = "id")
    private OrderTest orderTest;

    public Items(int quantity, Product product, OrderTest orderTest) {
        this.quantity = quantity;
        this.product = product;
        this.orderTest = orderTest;
    }

    public Items() {}
}
