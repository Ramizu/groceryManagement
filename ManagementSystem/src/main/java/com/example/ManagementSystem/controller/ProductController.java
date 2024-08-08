package com.example.ManagementSystem.controller;

import com.example.ManagementSystem.entity.Product;
import com.example.ManagementSystem.service.CategoryService;
import com.example.ManagementSystem.service.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/products")
    public String viewAllProducts(Model model, @ModelAttribute("message") String message) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("message", message);
        return "/products";
    }

    @GetMapping("/product-add")
    public String viewAddProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product-add";
    }

    @PostMapping("/addProduct")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes) {
        if (productService.saveOrUpdateProduct(product)) {
            redirectAttributes.addFlashAttribute("message", "Successfully saved!");
            return "redirect:/products";
        }

        redirectAttributes.addFlashAttribute("message", "Failed to save!");
        return "redirect:/product-add";
    }

    @GetMapping("/product-edit")
    public String viewEditProduct(@RequestParam Long prod_ID, Model model) {
        model.addAttribute("product", productService.getProductById(prod_ID));
        return "/product-edit";
    }

//    @PostMapping("/updateProduct")
//    public String editSaveProduct(Product product, RedirectAttributes redirectAttributes) {
//        if (productService.saveOrUpdateProduct(product)) {
//            redirectAttributes.addFlashAttribute("message", "Successfully edited!");
//            return "redirect:/products";
//        }
//
//        redirectAttributes.addFlashAttribute("message", "Failed to edit!");
//        return "redirect:/product-edit?id=" + product.getProd_ID();
//    }

    @PostMapping("/updateProduct")
    public String updateProduct(@RequestParam Long prod_ID, RedirectAttributes redirectAttributes) {
        if(productService.updateProduct(prod_ID)) {
            redirectAttributes.addFlashAttribute("message", "Successfully updated!");
            return "redirect:/products";
        }

        redirectAttributes.addFlashAttribute("message", "Failed to update!");
        return "redirect:/products";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam Long prod_ID, RedirectAttributes redirectAttributes) {
        if (productService.deleteProduct(prod_ID)) {
            redirectAttributes.addFlashAttribute("message", "Successfully deleted!");
        }

        redirectAttributes.addFlashAttribute("message", "Failed to delete!");
        return "redirect:/products";
    }
}
