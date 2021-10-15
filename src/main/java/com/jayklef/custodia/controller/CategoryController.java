package com.jayklef.custodia.controller;

import com.jayklef.custodia.model.Category;
import com.jayklef.custodia.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/categories")
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping("/categories")
    public List<Category> getCategoriesList(){
        return categoryService.getCategoriesList();
    }

    public Category getCategoryById(@PathVariable("id") Long categoryId,
                                    @RequestBody Category category){
        return categoryService.getCategoryById(categoryId, category);
    }


}
