package com.example.demo.services;


import com.example.demo.entity.Article;
import com.example.demo.repositories.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepo articleRepo;
// finding all records
    public List<Article> getAll() {
        return articleRepo.findAll();
    }
// saving on record att a time
    public Article save(Article article) {
        return articleRepo.save(article);
    }

// finding a record using id of the record
    public Article findById(Long id) {
        if (articleRepo.findById(id).isPresent()) {
            return articleRepo.findById(id).get();
        }
        return null;
    }
}

