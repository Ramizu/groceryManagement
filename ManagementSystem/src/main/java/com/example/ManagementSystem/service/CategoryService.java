
package com.example.ManagementSystem.service;

import com.example.ManagementSystem.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long categoryID);
    Category addCategory(Category category);
    Category updateCategory(Long categoryID, Category category);
    void deleteCategory(Long categoryID);
}
