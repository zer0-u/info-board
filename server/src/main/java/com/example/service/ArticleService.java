package com.example.service;

import com.example.persistence.ArticleMapper;
import com.example.persistence.ImageMapper;
import com.example.persistence.entity.Article;
import com.example.web.request.ArticleRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleMapper articleMapper;
    private final ImageMapper imageMapper;

    public ArticleService(ArticleMapper articleMapper, ImageMapper imageMapper) {
        this.articleMapper = articleMapper;
        this.imageMapper = imageMapper;
    }

    @Transactional(readOnly = true)
    public List<Article> findAll() {
        return articleMapper.findAll();
    }

    @Transactional
    public Integer add(ArticleRequest request) {
        Article article = new Article(request);
        articleMapper.add(article);
        Integer articleId = article.getId();
        request.getImages().forEach(imageRequest -> {
            imageMapper.save(imageRequest, articleId);
        });
        return articleId;
    }
}
