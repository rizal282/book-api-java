package com.book.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.book.models.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    
}
