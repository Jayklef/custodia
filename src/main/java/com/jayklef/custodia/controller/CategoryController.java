package com.jayklef.custodia.controller;

import com.jayklef.custodia.exception.CategoryNotFoundException;
import com.jayklef.custodia.model.Category;
import com.jayklef.custodia.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        log.info("Inside saveCategory of CategoryController");
        Category newCategory = categoryService.saveCategory(category);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @GetMapping("/getCategoriesList")
    public ResponseEntity<List<Category>> getCategoriesList(){
        log.info("Inside getCategoriesList of CategoryController");
        List<Category> categoryList = categoryService.findAllCategories();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/categoryId")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long categoryId) throws CategoryNotFoundException {
        log.info("Inside getCategoryById of CategoryController");
        Category category = categoryService.findCategoryById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }


}
