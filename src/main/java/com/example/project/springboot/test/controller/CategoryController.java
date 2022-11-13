package com.example.project.springboot.test.controller;

import com.example.project.springboot.test.entity.Category;
import com.example.project.springboot.test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/categories")
    public Category createCategory(@RequestBody final Category category){
        return categoryService.createNewCategory(category);
    }

    @GetMapping("/category/{id}")
    public Category getCategoryById(@PathVariable final Integer id){
        return categoryService.findCategoryById(id);
    }

    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable final Integer id,@RequestBody final Category category){
        return categoryService.updateCategory(id,category);
    }

    @DeleteMapping("/categories/{id}")
    public boolean deleteCategory(@PathVariable final Integer id){
       return categoryService.deleteCategory(id);
    }
}
