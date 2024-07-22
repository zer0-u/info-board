package com.example.web.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ArticleRequest {

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String author;

    @NotNull
    @NotBlank
    private String content;

    @NotNull
    private List<ImageRequest> images;

    public ArticleRequest(String title, String author, String content, List<ImageRequest> images) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public List<ImageRequest> getImages() {
        return images;
    }
}
