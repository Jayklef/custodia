package com.jayklef.custodia.service;

import com.jayklef.custodia.model.Category;
import com.jayklef.custodia.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategoriesList() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId, Category category) {
        return categoryRepository.findById(categoryId).get();
    }

}
