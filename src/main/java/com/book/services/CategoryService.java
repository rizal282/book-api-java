package com.book.services;

import java.util.Optional;

import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.models.entity.Category;
import com.book.models.repository.CategoryRepository;

@Service
@TransactionScoped
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);

        if(!category.isPresent()){
            return null;
        }

        return category.get();
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
