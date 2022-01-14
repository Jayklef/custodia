package com.jayklef.custodia.service;

import com.jayklef.custodia.exception.CategoryNotFoundException;
import com.jayklef.custodia.model.Category;

import java.util.List;

public interface CategoryService {
     Category saveCategory(Category category);

     List<Category> findAllCategories();

     Category findCategoryById(Long categoryId) throws CategoryNotFoundException;
}
