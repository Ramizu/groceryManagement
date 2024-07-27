package com.example.ManagementSystem.rest;

import com.example.ManagementSystem.entity.User;
import com.example.ManagementSystem.service.UserService;
import com.example.ManagementSystem.service.pojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    private pojo poj;

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody User user){
        String status = userService.upsert(user);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/user/{uid}")
    public ResponseEntity<User> getUser(@PathVariable Integer uid){
        User user = userService.getById(uid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUsers();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<String> updateUser(@RequestBody User user){
        String status = userService.upsert(user);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/user/{uid}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer uid){
        String status = userService.deleteById(uid);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        List<User> allUser = userService.getAllUsers();
        for(User u: allUser){
            if(u.getUser_name().equals(user.getUser_name()) && u.getUser_pswd().equals(user.getUser_pswd())){
                user = userService.getById(u.getUid());
                return new ResponseEntity<>(user,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
