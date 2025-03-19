package com.toan.english_center.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
//    private final String secret = "your_secret_key"; // Nên lưu trong file cấu hình hoặc biến môi trường
    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Generate a secure key
    private final long expirationTime = 86400000; // 1 ngày (miliseconds)

//    public String generateToken(String subject, String role) {
//        return Jwts.builder()
//                .setSubject(subject)
//                .claim("role", role)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
//                .signWith(SignatureAlgorithm.HS256, secret)
//                .compact();
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public String extractSubject(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
//    }
//
//    public String extractRole(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("role", String.class);
//    }
public String generateToken(String subject, String role) {
    return Jwts.builder()
            .setSubject(subject)
            .claim("role", role)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
            .signWith(secretKey)
            .compact();
}

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractSubject(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }

    public String extractRole(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().get("role", String.class);
    }
}
