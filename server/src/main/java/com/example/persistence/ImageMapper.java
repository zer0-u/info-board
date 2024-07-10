package com.example.persistence;

import com.example.persistence.entity.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ImageMapper {
    @Select("SELECT id, name, schema, image FROM images WHERE id = #{id}")
    Image getImageById(int id);
}
