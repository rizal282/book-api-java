package com.book.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.book.models.entity.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    
}
