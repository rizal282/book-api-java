package com.book.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.dto.ResponseData;
import com.book.models.entity.Book;
import com.book.services.BookService;

@RequestMapping("/api/book")
@RestController
@EnableAutoConfiguration
public class BookController {
    
    @Autowired
    private BookService bookService;

    // dengan tambahan validasi
    @PostMapping("/save-book")
    public ResponseEntity<ResponseData<Book>> create(@Valid @RequestBody Book book, Errors errors) {
        
        ResponseData<Book> responseData = new ResponseData<>();

        if(errors.hasErrors()){ // cek jika ada error
            for (ObjectError error : errors.getAllErrors()) { // looping error
                // System.err.println(error.getDefaultMessage());
                responseData.getMessage().add(error.getDefaultMessage()); // push error-nya ke array
            }

            responseData.setStatus(false); // set status response
            responseData.setPayload(null); // message response

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

            // throw new RuntimeException("Validation Error");
        }

        responseData.setStatus(true);
        responseData.setPayload(bookService.create(book));
        
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/all-books")
    public Iterable<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/find/{id}")
    public Book findById(@PathVariable("id") Long id) {
        return bookService.findById(id);
    }

    @PutMapping("/update-book")
    public Book update(@RequestBody Book book) {
        return bookService.create(book);
    }

    @DeleteMapping("/remove-book/{id}")
    public void removeBook(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
    }
}
