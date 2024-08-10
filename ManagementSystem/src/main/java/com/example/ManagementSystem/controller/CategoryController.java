package com.example.ManagementSystem.controller;


import com.example.ManagementSystem.entity.Category;
import com.example.ManagementSystem.entity.CategoryDTO;
import com.example.ManagementSystem.entity.User;
import com.example.ManagementSystem.service.CategoryService;
import com.example.ManagementSystem.service.CategoryServiceImpl;
import com.example.ManagementSystem.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping({"/", ""})
    public String displayCategoryList(Model model){ //to show list of category page
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "category";
    }


//    @GetMapping("/product")
//    public Category getCategoryById(@PathVariable int id) {
//        return categoryService.getCategoryById(id);
//    }

    @GetMapping("/addCategory")
    public String displayAddCategory(Model model){ //to create user page
        CategoryDTO categoryDTO = new CategoryDTO();
        model.addAttribute("categoryDTO", categoryDTO);
//        return "user/CreateUser"; //user is folder name, CreateUser is html file name
        return "category-add";
    }

    @PostMapping("/addCategory")
    public String addCategory(@Valid @ModelAttribute CategoryDTO categoryDTO, BindingResult result) {

        if(result.hasErrors()){
            return "category-add";
        }
        Category category = new Category();
        category.setCategory_name(categoryDTO.getCategory_name());
        category.setCategory_desc(categoryDTO.getCategory_desc());
        categoryService.addCategory(category);

        return "redirect:/category";
    }

    @GetMapping("/updateCategory")
    public String displayUpdatedCategory(Model model,@RequestParam int id) {

        try{
            Category category = categoryService.getCategoryById(id);
            model.addAttribute("category",category);

            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setCategory_name(category.getCategory_name());
            categoryDTO.setCategory_desc(category.getCategory_desc());

            model.addAttribute("categoryDTO",categoryDTO);
        }catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
            return "redirect:/category";
        }
        return "category-edit";
    }

    @PostMapping("/updateCategory")
    public String updateCategory(Model model, @RequestParam int id, @Valid @ModelAttribute CategoryDTO categoryDTO, BindingResult result){ //to update user info

        try{
            Category category = categoryService.getCategoryById(id);
            model.addAttribute("category", category);

            if(result.hasErrors()){
                return "category-edit";
            }

            category.setCategory_name(categoryDTO.getCategory_name());
            category.setCategory_desc(categoryDTO.getCategory_desc());


            categoryService.addCategory(category);

        }catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
        }
        return "redirect:/category";
    }

    @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam int id) {
        try{
            categoryService.deleteCategory(id);
        }catch(Exception e){
            System.out.println("Exception: "+e.getMessage());
        }
        return "redirect:/category";
    }
}