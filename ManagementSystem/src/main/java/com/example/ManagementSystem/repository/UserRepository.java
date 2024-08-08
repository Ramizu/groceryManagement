package com.example.ManagementSystem.repository;

import com.example.ManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {

    public User findByEmail(String email);

}
