package com.example.ManagementSystem.repository;

import com.example.ManagementSystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

//test
@Repository
public interface CategoryRepository extends JpaRepository<Category, Serializable> {
}
