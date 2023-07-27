package com.example.core.repository;

import com.example.core.model.modelRedundant.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
