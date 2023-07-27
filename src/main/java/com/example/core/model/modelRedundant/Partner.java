package com.example.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "partner")
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Person person;

    @Embedded
    private Account account;

    @ManyToMany
    @JoinColumn(name = "ordertest_id", referencedColumnName = "id")
    private List<OrderTest> pedidos;
}
