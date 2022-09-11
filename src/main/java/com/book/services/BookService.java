package com.book.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.book.models.entity.Book;
import com.book.models.repository.BookRepository;

@Service
@Transactional
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if(!book.isPresent()){
            return null;
        }

        return book.get();
    }

    public Iterable<Book> findAll(){
        return bookRepository.findAll();
    }
    
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findByName(String name) {
        return bookRepository.findByNamaContains(name);
    }

}
