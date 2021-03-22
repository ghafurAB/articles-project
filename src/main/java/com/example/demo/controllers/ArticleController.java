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
    @GetMapping("/articles") // mapping to the listing records service
public List<Article> getAll(){
    return articleService.getAll();
    }

    @GetMapping("/articles/{id}")  // mapping to the finding record service
    public Article getById(@PathVariable Long id){
        return articleService.findById(id);
    }


    @PostMapping("/articles")  // mapping to the saving records service
    public Article save(@RequestBody Article article){
        return articleService.save(article);
    }

    @DeleteMapping ("/articles/{id}")  // mapping to delete a record service
    public void  deleteById(@PathVariable Long id){
        articleService.deleteById(id);
    }

    @PutMapping ("/articles/{id}")  // mapping to delete a record service
    public void  updateById(@PathVariable Long id, @RequestBody Article article){
        articleService.updateById(id, article);
    }
}
