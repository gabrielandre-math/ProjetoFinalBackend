package com.gabriel.smarorder.config.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt.expiration}")
    private Long expiration;

    // Use a secure key generator for HS512
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
    }
}
