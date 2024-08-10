package com.example.ManagementSystem.controller;

import com.example.ManagementSystem.entity.Product;
import com.example.ManagementSystem.entity.Sales;
import com.example.ManagementSystem.entity.User;
import com.example.ManagementSystem.entity.UserDTO;
import com.example.ManagementSystem.service.ProductService;
import com.example.ManagementSystem.service.SalesServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/sales-product")
public class StaffSalesController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SalesServiceImpl salesService;

    @GetMapping({"","/"})
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "/sales-product";
    }

    @GetMapping("/updateProduct")
    public String updateProduct(@RequestParam Long prodId, Model model) {
        Product product = productService.getProductById(prodId);
        if (product == null) {
            model.addAttribute("errorMessage", "Product not found.");
            return "sales-product";
        }
        model.addAttribute("product", product);
        return "salesEditProduct";
    }

    @PostMapping("/updateProduct")
    public String updateProduct( @ModelAttribute Product product,@RequestParam(name = "newAvailability") int newAvailability,Model model){ //handle user creation

        System.out.println("Testing: " + newAvailability);
        Product products = new Product();
        Product product1 = productService.getProductById(product.getProd_ID());
        products.setProd_name(product.getProd_name());
        products.setProd_price(product.getProd_price());
        products.setAvailability(product.getAvailability());
        products.setCreated_date(product1.getCreated_date());
        products.setProd_ID(product1.getProd_ID());

        Sales sales = new Sales();
        sales.setProdId(products.getProd_ID());
        sales.setProdName(products.getProd_name());
        sales.setAvailability(newAvailability);
        double total = newAvailability * products.getProd_price();
        sales.setProdPrice(total);


        if (product == null) {
            model.addAttribute("errorMessage", "Product not found.");
            return "salesEditProduct";
        }

        if (newAvailability > product.getAvailability()) {
            model.addAttribute("errorMessage", "Entered quantity exceeds available stock.");
            model.addAttribute("product", product);
            return "salesEditProduct";
        } else {
            products.setAvailability(product.getAvailability() - newAvailability);
            productService.saveOrUpdateProduct(products);
            salesService.addSales(sales);
            return "redirect:/sales-product";
        }





    }

//    @PostMapping("/updateProduct")
//    public String updateProduct(@RequestParam Long prodId,
//                                @RequestParam int newAvailability,
//                                Model model) {
//        Product product = productService.getProductById(prodId);
//        if (product == null) {
//            model.addAttribute("errorMessage", "Product not found.");
//            return "sales-product/updateProduct";
//        }
//
//        if (newAvailability > product.getAvailability()) {
//            model.addAttribute("errorMessage", "Entered quantity exceeds available stock.");
//            model.addAttribute("product", product);
//            return "sales-product/updateProduct";
//        } else {
//            product.setAvailability(product.getAvailability() - newAvailability);
//            productService.updateProduct(product);
//            return "redirect:/sales-product/updateProduct";
//        }
//    }
}