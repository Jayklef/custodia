package com.jayklef.custodia.service;

import com.jayklef.custodia.model.Category;

import java.util.List;

public interface CategoryService {
     Category saveCategory(Category category);

     List<Category> getCategoriesList();

     Category getCategoryById(Long categoryId, Category category);
}
