package com.example.ManagementSystem.controller;


import com.example.ManagementSystem.entity.Category;
import com.example.ManagementSystem.entity.User;
import com.example.ManagementSystem.service.CategoryService;
import com.example.ManagementSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping({"", "/"})
    public String showUserList(Model model){ //to show list of user page
//        List<User> users = categoryService.getAllCategories();
//        model.addAttribute("users", users);
        return "category";
    }

    @GetMapping("/category")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/product")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/updateCategoryName/{prod_ID}")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/update")
    public Category updateCategory(@PathVariable Long categoryID, @RequestBody Category category) {
        return categoryService.updateCategory(categoryID, category);
    }

    @DeleteMapping("/delete")
    public void deleteCategory(@PathVariable Long categoryID) {
        categoryService.deleteCategory(categoryID);
    }
}
