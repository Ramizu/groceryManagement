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

    @GetMapping({"", "/"})
    public String showlogin(Model model){
        UserDTO userDto = new UserDTO();
        model.addAttribute("userDTO", userDto);
        return "pages-login";
    }

    @PostMapping({"", "/"})
    public String checklogin(@ModelAttribute UserDTO userDTO, Model model){
        User user = new User();
        user = userService.findByEmail(userDTO.getEmail());
        System.out.println(user);
        if(null != user) {
            if (userDTO.getEmail().equals(user.getEmail()) && userDTO.getUser_pswd().equals(user.getUser_pswd())) {
                model.addAttribute("user", user);
                if(user.getIs_admin().equalsIgnoreCase("Y"))
                    return "dashboard";
                else
                    return "dashboard-staff";
            }
        }
        model.addAttribute("errorMessage", "Invalid email or password. Please try again.");
        return "pages-login";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }

    @GetMapping("/dashboard-staff")
    public String dashboardStaff(){
        return "dashboard-staff";
    }

    @GetMapping({"/users-profile", "/users-profile.html"})
    public String userProfile(@RequestParam(name = "userValue", required = false) String uid,Model model, @RequestParam(required = false) String id){

//        UserDTO userDto = new UserDTO();
        try {
            System.out.println("uid, id : "+uid+", "+id);
            User user = new User();
            if(null != id){
                int newID = Integer.parseInt(id);
                user = userService.getById(newID);
            }else if(null != uid){
                int newID = Integer.parseInt(uid);
                user = userService.getById(newID);
            }
            model.addAttribute("userDTO", user);
        }catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
            return "users-profile";
        }
        return "users-profile";
    }

    @PostMapping({"/users-profile", "/users-profile.html"})
    public String updateUser(Model model, @ModelAttribute UserDTO userDTO, BindingResult result) { //to update user info

        int userid = 0;
        try {
            User user = userService.findByEmail(userDTO.getEmail());
            model.addAttribute("user", user);

//            if(result.hasErrors()){
//                System.out.println("edit result has error!");
//                return "user-edit";
//            }

            user.setUser_name(userDTO.getUser_name());
//            user.setUser_pswd(userDTO.getUser_pswd());
//            user.setIs_admin(userDTO.getIs_admin());
            user.setEmail(userDTO.getEmail());
            user.setPhone_num(userDTO.getPhone_num());

            userService.upsert(user);
            model.addAttribute("userDTO", user);
            userid = user.getUid();

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return "redirect:/users-profile?userValue=" + userid;
    }
}
