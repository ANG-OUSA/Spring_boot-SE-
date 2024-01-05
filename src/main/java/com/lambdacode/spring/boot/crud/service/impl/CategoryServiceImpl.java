package com.lambdacode.spring.boot.crud.service.impl;

import com.lambdacode.spring.boot.crud.entity.Categories;
import com.lambdacode.spring.boot.crud.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl {

    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(Categories category) {
        categoryRepository.save(category);
    }

    public List<Categories> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Categories getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void updateCategory(Long id, Categories category) {
        // Check whether the category is in the database or not
        if (categoryRepository.existsById(id)) {
            category.setCategoryId(id);
            categoryRepository.save(category);
        }
        // Handle if the category is not found
    }

    public void deleteCategory(Long id) {
        // Check whether the category is in the database or not
        categoryRepository.findById(id).ifPresent(categoryRepository::delete);
        // Handle if the category is not found
    }
}
