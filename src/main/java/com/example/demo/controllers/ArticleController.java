package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    // Create Post -- Read Get -- Update Put -- Delete Delete

    @GetMapping("/hi")
    public String hi(){
        return "Hi There";
    }

}
