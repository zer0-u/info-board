package com.example.persistence.entity;

import com.example.web.request.ArticleRequest;

import java.time.LocalDateTime;

public class Article {

    private Integer id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public Article(Integer id, String author, String title, String content, LocalDateTime createdAt) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Article(ArticleRequest request) {
        this.title = request.getTitle();
        this.author = request.getAuthor();
        this.content = request.getContent();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
