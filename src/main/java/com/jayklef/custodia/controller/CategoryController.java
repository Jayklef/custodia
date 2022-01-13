package com.jayklef.custodia.controller;

import com.jayklef.custodia.model.Category;
import com.jayklef.custodia.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/categoris")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category){
        log.info("Inside saveCategory of CategoryController");
        return categoryService.saveCategory(category);
    }

    @GetMapping("/getCategoriesList")
    public List<Category> getCategoriesList(){
        log.info("Inside getCategoriesList of CategoryController");
        return categoryService.getCategoriesList();
    }

    @GetMapping("/categoryId")
    public Category getCategoryById(@PathVariable("id") Long categoryId,
                                    @RequestBody Category category){
        log.info("Inside getCategoryById of CategoryController");
        return categoryService.getCategoryById(categoryId, category);
    }


}
