package com.example.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true)
    private String CNPJ;

    @Column(length = 20)
    private String razaoSocial;

    @Column(length = 12)
    private String phone;

    @Embedded
    private Address address;

    @Column(length = 20)
    private String nomeFantasia;

    public Company() {}

    public Company(Long id,
                   String CNPJ,
                   String razaoSocial,
                   String phone,
                   Address address,
                   String nomeFantasia) {
        this.id = id;
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
        this.phone = phone;
        this.address = address;
        this.nomeFantasia = nomeFantasia;
    }
}
