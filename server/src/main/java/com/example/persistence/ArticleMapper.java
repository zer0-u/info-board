package com.example.persistence;

import com.example.persistence.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("SELECT id, author, title, content, created_at FROM articles ORDER BY id")
    public List<Article> findAll();
}
