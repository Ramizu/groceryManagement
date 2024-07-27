package com.example.ManagementSystem.service;

import com.example.ManagementSystem.entity.User;
import com.example.ManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Override
    public String upsert(User user) {
        userRepo.save(user); // update / insert table
        return "Success";
    }

    @Override
    public User getById(Integer uid) {
        Optional<User> findById =  userRepo.findById(uid);

        if(findById.isPresent()){
            return findById.get();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public String deleteById(Integer uid) {
        if(userRepo.existsById(uid)){
            userRepo.deleteById(uid);
            return "Delete Success";
        }else{
            return "No record found";
        }

    }
}
