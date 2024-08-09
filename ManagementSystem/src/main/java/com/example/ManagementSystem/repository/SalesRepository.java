package com.example.ManagementSystem.repository;

import com.example.ManagementSystem.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales,Long> {
}
