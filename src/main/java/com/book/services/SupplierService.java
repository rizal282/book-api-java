package com.book.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.models.entity.Supplier;
import com.book.models.repository.SupplierRepository;

@Service
@Transactional
public class SupplierService {
    
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier findById(Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);

        if(!supplier.isPresent()){
            return null;
        }

        return supplier.get();
    }

    public Iterable<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}
