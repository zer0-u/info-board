package com.example.persistence.entity;

import java.util.List;

public class User {

    private Integer id;
    private String loginId;
    private String password;
    private String name;
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
