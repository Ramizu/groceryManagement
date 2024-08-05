package com.example.ManagementSystem.controller;

import com.example.ManagementSystem.entity.Product;
import com.example.ManagementSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String viewAllProducts(Model model, @ModelAttribute("message") String message) {
        model.addAttribute("list", productService.getAllProducts());
        model.addAttribute("message", message);
        return "products";
    }

    @PostMapping("/updateProductName/{prod_ID}")
    public String updateProductName(@PathVariable Long prod_ID, RedirectAttributes redirectAttributes) {
        if(productService.updateProductName(prod_ID)) {
            redirectAttributes.addFlashAttribute("message", "Successfully updated!");
            return "redirect:/products";
        }

        redirectAttributes.addFlashAttribute("message", "Failed to update!");
        return "redirect:/products";
    }

//    @PostMapping
//    public String updateProductPrice() {}
//
//    @PostMapping
//    public String updateProductAvailability() {}

    @GetMapping("/product-add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());

        return "product-add";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes) {
        if (productService.saveOrUpdateProduct(product)) {
            redirectAttributes.addFlashAttribute("message", "Successfully saved!");
            return "redirect:/products";
        }

        redirectAttributes.addFlashAttribute("message", "Failed to save!");
        return "redirect:/product-add";
    }

    @GetMapping("/editProduct/{prod_ID}")
    public String editProduct(@PathVariable Long prod_ID, Model model) {
        model.addAttribute("product", productService.getProductById(prod_ID));
        return "EditProduct";
    }

    @PostMapping("/editSaveProduct")
    public String editSaveProduct(Product product, RedirectAttributes redirectAttributes) {
        if (productService.saveOrUpdateProduct(product)) {
            redirectAttributes.addFlashAttribute("message", "Successfully edited!");
            return "redirect:/products";
        }

        redirectAttributes.addFlashAttribute("message", "Failed to edit!");
        return "redirect:/editProduct/" + product.getProd_ID();
    }

    @GetMapping("/deleteProduct/{prod_ID}")
    public String deleteProduct(@PathVariable Long prod_ID, RedirectAttributes redirectAttributes) {
        if (productService.deleteProduct(prod_ID)) {
            redirectAttributes.addFlashAttribute("message", "Successfully deleted!");
        }

        redirectAttributes.addFlashAttribute("message", "Failed to delete!");
        return "redirect:/products";
    }
}
