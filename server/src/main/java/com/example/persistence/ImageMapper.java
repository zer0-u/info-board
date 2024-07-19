package com.example.persistence;

import com.example.persistence.entity.Image;
import com.example.web.request.ImageRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImageMapper {

    @Select("SELECT id, name, header, base64 FROM images WHERE article_id = #{id}")
    List<Image> findByArticleId(int id);

    @Insert("INSERT INTO images(article_id, name, header, base64) VALUES(#{articleId}, #{request.name}, #{request.header}, #{request.base64})")
    void save(@Param("request") ImageRequest request, @Param("articleId") int articleId);
}
