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
    public List<Article> getAll(){
        return articleRepo.findAll();
    }

    public Article save(Article article){
        return articleRepo.save(article);
    }
}
