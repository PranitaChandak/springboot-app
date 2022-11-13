package com.example.project.springboot.test.service;

import com.example.project.springboot.test.entity.Category;
import com.example.project.springboot.test.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category createNewCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category findCategoryById(Integer id){
        return Optional.ofNullable(categoryRepository.findById(id)).orElseThrow().orElse(new Category());
    }

    public Category updateCategory(Integer id,Category updatedCategory){
       categoryRepository.findById(id).
               map(c->
       {
           c.setCategoryName(updatedCategory.getCategoryName());
           return categoryRepository.save(c);
       }).orElseGet(
                       ()->{
                           updatedCategory.setCategoryId(id);
                           return categoryRepository.save(updatedCategory);
                       }
               );
        return updatedCategory;
    }
    
    public boolean deleteCategory(Integer id){
        boolean doesExist= categoryRepository.findById(id).isPresent();
        if(doesExist){
            categoryRepository.deleteById(id);
            return true;
        }else{
            System.out.println("Given record with id"+id+ "could not found");
            return false;
        }

    }
}
