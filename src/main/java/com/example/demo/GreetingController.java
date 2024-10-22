package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GreetingController {

    @GetMapping("/greet")
    public String greet() {
        int i=3;
        System.out.println("int is"+i);
        return "Hello, Welcome to the Restaurant API!";
    }
}
