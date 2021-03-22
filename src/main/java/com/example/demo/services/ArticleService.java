package com.example.demo.services;


import com.example.demo.entity.Article;
import com.example.demo.repositories.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.lang.reflect.Field;
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

    public void  deleteById(Long id) {
        articleRepo.deleteById(id);
    }

    public void updateById(Long id, Article article) {
        Article fromDb=findById(id);
        if (fromDb != null){
            Field[] fields =article.getClass().getDeclaredFields();
            try {
                for (Field field : fields){
                    field.setAccessible(true);
                    if (field.get(article) != null && !field.isAnnotationPresent(Id.class)){
                        field.set(fromDb, field.get(article));
                    }
                }
            }
            catch (IllegalAccessException e){
                e.printStackTrace();
            }
            articleRepo.save(fromDb);
        }
    }
}

