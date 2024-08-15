package com.example.auth;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtTokenProvider {

    private final String ISSUER_NAME = "info-board";
    private final String CLAIM_KEY_USERNAME = "username";
    private final String CLAIM_KEY_ROLES = "roles";

    private final String SECRET_KEY = "dummy_secret_value";
    private final Algorithm algorithm;

    public JwtTokenProvider() {
        algorithm = Algorithm.HMAC256(SECRET_KEY);
    }

    public String generateToken(Authentication authentication) {
        List<String> roleNames = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        return JWT.create()
                .withIssuer(ISSUER_NAME)
                .withClaim(CLAIM_KEY_USERNAME, authentication.getName())
                .withClaim(CLAIM_KEY_ROLES, roleNames)
                .sign(algorithm);
    }

    public boolean isValid(String token) {
        try {
            decode(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return decode(token).getClaim(CLAIM_KEY_USERNAME).asString();
    }

    private DecodedJWT decode(String token) throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(ISSUER_NAME)
                .withClaimPresence(CLAIM_KEY_USERNAME)
                .withClaimPresence(CLAIM_KEY_ROLES)
                .build();
        return verifier.verify(token);
    }
}
