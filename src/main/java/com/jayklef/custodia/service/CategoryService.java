package com.jayklef.custodia.service;

import com.jayklef.custodia.model.Category;

import java.util.List;

public interface CategoryService {
    public Category saveCategory(Category category);

    public List<Category> getCategoriesList();

    public Category getCategoryById(Long categoryId, Category category);
}
