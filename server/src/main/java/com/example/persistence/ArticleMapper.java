package com.example.persistence;

import com.example.persistence.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("SELECT id, author, title, content, created_at FROM articles ORDER BY id")
    List<Article> findAll();

    @Insert("INSERT INTO articles(author, title, content) VALUES(#{author},#{title},#{content})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void add(Article article);
}
