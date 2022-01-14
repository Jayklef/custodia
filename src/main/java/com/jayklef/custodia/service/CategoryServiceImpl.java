package com.jayklef.custodia.service;

import com.jayklef.custodia.exception.CategoryNotFoundException;
import com.jayklef.custodia.model.Category;
import com.jayklef.custodia.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Long categoryId) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepository.findById(categoryId);

        if (categoryId == null){
            throw new CategoryNotFoundException("Category Not found");
        }
        return categoryRepository.findById(categoryId).get();
    }

}
