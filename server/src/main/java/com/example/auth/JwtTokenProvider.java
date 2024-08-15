package com.example.auth;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtTokenProvider {

    public String generateToken(Authentication authentication) {
        List<String> roleNames = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        return JWT.create()
                .withIssuer("info-board")
                .withClaim("username", authentication.getName())
                .withClaim("role", roleNames)
                .sign(Algorithm.HMAC256("secret"));
    }

    public boolean isValid(String token) {
        return true;
    }

    public String getUsernameFromToken(String token) {
        return "admin01";
    }
}
