package com.example.ManagementSystem.controller;

import com.example.ManagementSystem.entity.User;
import com.example.ManagementSystem.entity.UserDTO;
import com.example.ManagementSystem.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

//    @GetMapping({"", "/"})
//    public String login(){
//        return "index";
//    }

    @GetMapping({"/users-profile", "/users-profile.html"})
    public String userProfile(){
        return "users-profile";
    }

    @GetMapping({"", "/"})
    public String showlogin(Model model){
        UserDTO userDto = new UserDTO();
        model.addAttribute("userDTO", userDto);
        return "pages-login";
    }

    @PostMapping({"", "/"})
    public String checklogin(@ModelAttribute UserDTO userDTO, Model model){
        User user = new User();
        user.setUser_name(userDTO.getUser_name());
        user.setUser_pswd(userDTO.getUser_pswd());
        user = userService.findByEmail(userDTO.getEmail());
        if(userDTO.getEmail().equals(user.getEmail()) && userDTO.getUser_pswd().equals(user.getUser_pswd())){
            model.addAttribute("user", user);
            return "dashboard";
        }
        return "pages-login";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
