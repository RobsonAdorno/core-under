package com.example.core.model.modelRedundant;

import com.example.core.enums.Role;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_db")
public class User  {
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

    @Column(length = 1000)
    private String password;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "token_id", referencedColumnName = "id")
//    private List<Token> tokens;


}
