package com.example.core.model.modelRedundant;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45)
    private String description;

    public Product(String descrp) {
        this.description = descrp;
    }

    public Product(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Product() {}
}
