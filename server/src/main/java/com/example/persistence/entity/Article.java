package com.example.persistence.entity;

import com.example.web.request.ArticleRequest;

import java.time.LocalDateTime;
import java.util.List;

public class Article {

    private Integer id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private List<Image> images;

    public Article() {
    }

    public Article(ArticleRequest request) {
        this.title = request.getTitle();
        this.author = request.getAuthor();
        this.content = request.getContent();
    }

    public Integer getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Image> getImages() {
        return images;
    }
}
