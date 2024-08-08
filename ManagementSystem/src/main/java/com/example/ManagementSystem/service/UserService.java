package com.example.ManagementSystem.service;

import com.example.ManagementSystem.entity.User;

import java.util.List;

public interface UserService {

    public String upsert(User user);

    public User getById(Integer uid);

    public List<User> getAllUsers();

    public String deleteById(Integer uid);

    public User findByEmail(String email);
}
