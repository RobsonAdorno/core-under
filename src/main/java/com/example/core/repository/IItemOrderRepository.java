package com.example.core.repository;

import com.example.core.DTOs.ItemsDTO;
import com.example.core.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@EnableJpaRepositories
@Repository
public interface IItemOrderRepository extends JpaRepository<Items, Long> {
    String query = "SELECT quantity, product_id \n" +
            "FROM ordertest o \n" +
            "INNER JOIN items i\n" +
            "WHERE o.id = i.ordertest_id AND o.client_id = ?1 ORDER BY o.datetime";

    @Transactional
    @Query(value = query, nativeQuery = true)
    List getItemForUserByDate(@Param("client_id") Long client_id);
}
