package com.example.ManagementSystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeWebController {

    @GetMapping({"/", "/index.html"})
    public String showLogin(){
        return "index";
    }
}
