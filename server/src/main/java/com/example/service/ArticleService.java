package com.example.service;

import com.example.persistence.ArticleMapper;
import com.example.persistence.entity.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleMapper mapper;

    public ArticleService(ArticleMapper mapper) {
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<Article> findAll() {
        return mapper.findAll();
    }

    @Transactional
    public void add(Article article) {
        mapper.add(article);
    }
}
