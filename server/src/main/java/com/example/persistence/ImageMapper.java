package com.example.persistence;

import com.example.persistence.entity.Image;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImageMapper {

    @Select("SELECT id, name, header, base64 FROM images WHERE article_id = #{id}")
    List<Image> findByArticleId(int id);

    @Select("SELECT id, article_id, name, header, base64 FROM images WHERE id = #{id}")
    Image findById(int id);

    @Select("SELECT id, name, header, base64 FROM images ORDER BY id")
    List<Image> findAll();

    @Insert("INSERT INTO images(name, header, base64) VALUES(#{name}, #{header}, #{base64})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(Image image);
}
