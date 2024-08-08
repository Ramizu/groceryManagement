package com.example.ManagementSystem.service;

import com.example.ManagementSystem.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Integer categoryid);
    String addCategory(Category category);
//    Category updateCategory(Long categoryID, Category category);
    String deleteCategory(Integer categoryid);
}
