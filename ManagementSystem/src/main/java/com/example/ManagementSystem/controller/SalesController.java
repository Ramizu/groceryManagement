package com.example.ManagementSystem.controller;


import com.example.ManagementSystem.entity.Product;
import com.example.ManagementSystem.entity.Sales;
import com.example.ManagementSystem.entity.User;
import com.example.ManagementSystem.service.ProductService;
import com.example.ManagementSystem.service.SalesServiceImpl;
import com.example.ManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/sales-admin")
public class SalesController {

    @Autowired
    private SalesServiceImpl salesService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @GetMapping("/addSales")
    public String addSales(Model model){
        List<Product> products = productService.getAllProducts();
        List<User> users = userService.getAllUsers();
        Sales sales = new Sales();
        model.addAttribute("sales",sales);
        model.addAttribute("products",products);
        model.addAttribute("users",users);
        return "sales-add";
    }

    @PostMapping("/addSales")
    public String addSales(@RequestParam Long prodId,
                           @RequestParam String prodName,
                           @RequestParam int availability,
                           @RequestParam double prodPrice,
                           Model model) {
        // Create a new Sales object
        Sales sales = new Sales(prodId, prodName, availability, prodPrice);

        // Save the Sales object using the SalesService
        salesService.addSales(sales);

        // Optionally, add a success message to the model
        model.addAttribute("message", "Sale added successfully!");

        // Redirect to a different page or return to the form view
        return "redirect:/sales"; // Redirect to list page or another appropriate view
    }

    @GetMapping({"","/"})
    public String listSales(Model model) {
        List<Sales> sales = salesService.getAllSales();
        model.addAttribute("sales", sales);
        return "sales-admin"; // View name to be rendered
    }



}