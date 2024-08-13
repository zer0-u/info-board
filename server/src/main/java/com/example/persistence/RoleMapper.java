package com.example.persistence;

import com.example.persistence.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("""
            SELECT r.id, r.name FROM roles r
            INNER JOIN user_role ur ON r.id = ur.role_id
            WHERE ur.user_id = #{userId}
            """)
    List<Role> findByUserId(Long userId);
}
