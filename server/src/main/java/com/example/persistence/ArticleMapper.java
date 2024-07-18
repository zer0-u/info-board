package com.example.persistence;

import com.example.persistence.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "author", property = "author"),
            @Result(column = "title", property = "title"),
            @Result(column = "content", property = "content"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "id", property = "images", many = @Many(select = "com.example.persistence.ImageMapper.findByArticleId"))
    })
    @Select("SELECT id, author, title, content, created_at FROM articles ORDER BY created_at DESC")
    List<Article> findAll();

    @Insert("INSERT INTO articles(author, title, content) VALUES(#{author},#{title},#{content})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void add(Article article);
}
