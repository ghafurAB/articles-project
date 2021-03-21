package com.example.demo.controllers;

import com.example.demo.entity.Article;
import com.example.demo.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ArticleController {

    // Create Post -- Read Get -- Update Put -- Delete Delete
@Autowired
private ArticleService articleService;
    @GetMapping("/articles")
public List<Article> getAll(){
    return articleService.getAll();
    }

    @PostMapping("/articles")
    public Article save(@RequestBody Article article){
        return articleService.save(article);
    }
}
