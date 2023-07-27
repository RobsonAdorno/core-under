package com.example.core.repository;

import com.example.core.model.modelRedundant.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IClientRepository extends JpaRepository<Client, Long> {
    String query = "select orde.client_id from " +
            "items i inner join ordertest orde on i.id = orde.id inner join client c on ?1 = orde.client_id";

    String email = "select * from user_db where email = ?1";
    @Query(value = query, nativeQuery = true)
    Optional<Integer> getOrderByIdClient(Long id);

    @Query(value = query, nativeQuery = true)
    Optional<Client> getClientByEmail(String email);
}
