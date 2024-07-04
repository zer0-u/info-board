package com.example.web;

import com.example.persistence.entity.Article;
import com.example.service.ArticleService;
import com.example.web.request.ArticleRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService service;

    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Article> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> post(@Validated @RequestBody ArticleRequest request) {
        Article article = new Article(request);
        service.add(article);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .pathSegment(article.getId().toString())
                .build().encode()
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
