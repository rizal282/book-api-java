package com.book.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeBookController {
    
    @GetMapping
    public String welcome() {
        return "Welcome to Book API using Java Spring Bootss";
        
    }
}
