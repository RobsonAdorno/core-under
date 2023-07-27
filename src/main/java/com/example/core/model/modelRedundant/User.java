package com.example.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "person_db")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true)
    private String cpf;

    @Column(length = 20)
    private String name;

    @Column(length = 30)
    private String lastName;

    @Column(length = 21)
    private String email;

    @Column(length = 30)
    private String password;
}
