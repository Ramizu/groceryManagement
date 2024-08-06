package com.example.ManagementSystem.controller;


import com.example.ManagementSystem.entity.Category;
import com.example.ManagementSystem.service.CategoryService;
import com.example.ManagementSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/updateCategoryName/{prod_ID}")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long categoryID, @RequestBody Category category) {
        return categoryService.updateCategory(categoryID, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long categoryID) {
        categoryService.deleteCategory(categoryID);
    }
}
