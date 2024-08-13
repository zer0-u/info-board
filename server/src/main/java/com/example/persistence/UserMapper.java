package com.example.persistence;

import com.example.persistence.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "login_id", property = "loginId"),
            @Result(column = "password", property = "password"),
            @Result(column = "name", property = "name"),
            @Result(column = "id", property = "roles",
                    many = @Many(select = "com.example.persistence.RoleMapper.findByUserId"))
    })
    @Select("SELECT id, login_id, password, name FROM users WHERE login_id = #{loginId}")
    User findByLoginId(String loginId);
}
