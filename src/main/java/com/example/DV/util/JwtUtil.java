package com.example.DV.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final long EXPIRATION_TIME = 86400000; // 1일 (밀리초 단위)
    private static final String SECRET = System.getenv("JWT_SECRET") != null
            ? System.getenv("JWT_SECRET")
            : "ReplaceThisWithASecureRandomKeyOfSufficientLength1234";
    // JWT 검증을 위한 키 반환 메소드
    @Getter
    private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public static String generateToken(String email) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + EXPIRATION_TIME);
        long iatSeconds = now.getTime() / 1000L;
        long expSeconds = exp.getTime() / 1000L;

        return Jwts.builder()
                .claim("sub", email)
                .claim("iat", iatSeconds)
                .claim("exp", expSeconds)
                .claim("iss", "DVApplication")
                .claim("aud", "DVClient")
                .signWith(key)
                .compact();
    }

}
