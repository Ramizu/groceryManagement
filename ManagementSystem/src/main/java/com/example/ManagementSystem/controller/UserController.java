package com.example.ManagementSystem.controller;

import com.example.ManagementSystem.entity.User;
import com.example.ManagementSystem.entity.UserDTO;
import com.example.ManagementSystem.service.UserService;
import com.example.ManagementSystem.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public String showLogin(){

        return "pages-login";
    }

//    @GetMapping
//    public String logout(){
//
//        return "index";
//    }

    @GetMapping({"", "/"})
    public String showUserList(Model model){ //to show list of user page
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "pages-staff";
    }

    @GetMapping("/create")
    public String showCreateUser(Model model){ //to create user page
        UserDTO userDto = new UserDTO();
        model.addAttribute("userDTO", userDto);
//        return "user/CreateUser"; //user is folder name, CreateUser is html file name
        return "user-add";
    }

    @PostMapping("/create")
    public String createUser(@Valid @ModelAttribute UserDTO userDTO, BindingResult result){ //handle user creation

        if(result.hasErrors()){
            return "user-add"; //user is folder name, CreateUser is html file name
        }
        User user = new User();
        user.setUser_name(userDTO.getUser_name());
        user.setUser_pswd(userDTO.getUser_pswd());
        user.setIs_admin(userDTO.getIs_admin());
        user.setEmail(userDTO.getEmail());
        user.setPhone_num(userDTO.getPhone_num());
        userService.upsert(user);

        return "redirect:/user";
    }

    @GetMapping("/edit")
    public String showEditUser(Model model, @RequestParam int id){ //to show edit user page

        try{
            User user = userService.getById(id);
            model.addAttribute("user", user);

            UserDTO userDto = new UserDTO();
            userDto.setUser_name(user.getUser_name());
            userDto.setUser_pswd(user.getUser_pswd());
            userDto.setIs_admin(user.getIs_admin());
            userDto.setEmail(user.getEmail());
            userDto.setPhone_num(user.getPhone_num());

            model.addAttribute("userDTO", userDto);
        }catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
            return "redirect:/user";
        }

        return "user-edit"; //user is folder name, EditUser is html file name
    }

    @PostMapping("/edit")
    public String updateUser(Model model, @RequestParam int id, @Valid @ModelAttribute UserDTO userDTO, BindingResult result){ //to update user info

        try{
            User user = userService.getById(id);
            model.addAttribute("user", user);

            if(result.hasErrors()){
                return "user-edit";
            }

            user.setUser_name(userDTO.getUser_name());
            user.setUser_pswd(userDTO.getUser_pswd());
            user.setIs_admin(userDTO.getIs_admin());
            user.setEmail(userDTO.getEmail());
            user.setPhone_num(userDTO.getPhone_num());

            userService.upsert(user);

        }catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
        }
        return "redirect:/user";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam int id){

        try{
            userService.deleteById(id);
        }catch (Exception e){
            System.out.println("Exception: "+e.getMessage());
        }

        return "redirect:/user";
    }
}
