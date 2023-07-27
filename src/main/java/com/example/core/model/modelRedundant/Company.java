package com.example.core.model.modelRedundant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
