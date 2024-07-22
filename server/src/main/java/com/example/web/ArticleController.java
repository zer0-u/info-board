package com.example.web;

import com.example.persistence.entity.Article;
import com.example.service.ArticleService;
import com.example.web.request.ArticleRequest;
import com.example.web.response.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
        Integer articleId = service.add(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .pathSegment(articleId.toString())
                .build().encode()
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse handleValidationException(MethodArgumentNotValidException e) {
        ValidationErrorResponse errorResponse = new ValidationErrorResponse("入力検証エラー");
        e.getBindingResult().getFieldErrors().forEach(
                fieldError -> errorResponse.addDetail(fieldError.getField(), fieldError.getDefaultMessage()));
        return errorResponse;
    }
}
