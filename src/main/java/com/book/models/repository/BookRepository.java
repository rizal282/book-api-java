package com.book.models.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book.models.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    
    List<Book> findByNamaContains(String nama);
}
