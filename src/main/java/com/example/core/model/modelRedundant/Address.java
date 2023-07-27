package com.example.core.model;

import javax.persistence.*;

@Embeddable
public class Address {
    @Column(length = 4)
    private String number;

    @Column(length = 30)
    private String logradouro;

    @Column(length = 20, unique = true)
    private String CEP;

    @Column(length = 30)
    private String bairro;

    public Address() {}

    public Address(String number,
                   String logradouro,
                   String CEP,
                   String bairro) {
        this.number = number;
        this.logradouro = logradouro;
        this.CEP = CEP;
        this.bairro = bairro;
    }
}
