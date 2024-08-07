package com.example.ManagementSystem.controller;

import com.example.ManagementSystem.entity.User;
import com.example.ManagementSystem.entity.UserDTO;
import com.example.ManagementSystem.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class IndexController {

    private UserService userService;

    @GetMapping({"", "/"})
    public String login(){
        return "index";
    }

    @GetMapping({"/users-profile", "/users-profile.html"})
    public String userProfile(){
        return "users-profile";
    }

//    @GetMapping("/pages-staff")
//    public String showlogin(){
//        return "pages-staff";
//    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
