package com.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public String findAll() {
        return "OK!";
    }

    @GetMapping("/authenticated")
    public String authenticated() {
        return "authenticated path";
    }

    @GetMapping("/admin-role")
    public String adminRole() {
        return "admin role path";
    }
}
