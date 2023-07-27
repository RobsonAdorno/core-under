package com.example.core.repository;

import com.example.core.model.modelRedundant.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user_db c WHERE c.email = ?1", nativeQuery = true)
    Optional<User> findByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM user_db c WHERE c.cpf = ?1", nativeQuery = true)
    Optional<User> getClientByCPF(@Param("cpf") String cpf);
}
