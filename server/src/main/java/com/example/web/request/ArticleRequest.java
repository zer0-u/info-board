package com.example.web.request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ArticleRequest {

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String author;

    @NotNull
    @NotEmpty
    private String content;

    public ArticleRequest(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public @NotNull @NotEmpty String getTitle() {
        return title;
    }

    public @NotNull @NotEmpty String getAuthor() {
        return author;
    }

    public @NotNull @NotEmpty String getContent() {
        return content;
    }
}
