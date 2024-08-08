package com.example.ManagementSystem.service;

import com.example.ManagementSystem.entity.Category;
import com.example.ManagementSystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer categoryid) {
        Optional<Category> findById = categoryRepository.findById(categoryid);

        if(findById.isPresent()){
            return findById.get();
        }
        return null;
    }

    @Override
    public String addCategory(Category category) {
        categoryRepository.save(category);  //add
        return "Success";
    }

//    @Override
//    public Category updateCategory(Long categoryID, Category category) {
//        Category existingCategory = categoryRepository.findById(categoryID).orElse(null);
//        if (existingCategory != null) {
//            existingCategory.setCategory_name(category.getCategory_name());
//            return categoryRepository.save(existingCategory);
//        }
//        return null;
//    }

    @Override
    public String deleteCategory(Integer categoryid) {
        if(categoryRepository.existsById(categoryid)){
            categoryRepository.deleteById(categoryid);
            return "Delete Category Success";
        }else{
            return "Not record found";
        }

    }


}
