package com.example.core.repository;

import com.example.core.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface IClientRepository extends JpaRepository<Client, Long> {
    String query = "select orde.client_id from " +
            "items i inner join ordertest orde on i.id = orde.id inner join client c on ?1 = orde.client_id";

    @Query(value = query, nativeQuery = true)
    Optional<Integer> getOrderByIdClient(Long id);

    @Query(value = "select * from client c where c.cpf = ?1", nativeQuery = true)
    Optional<Client> getClientByCPF(String cpf);
}
