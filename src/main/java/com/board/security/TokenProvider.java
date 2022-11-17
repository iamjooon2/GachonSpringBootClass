package com.board.security;

import com.board.domain.UserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import org.springframework.stereotype.Service;

// JWT 토큰을 발급해주는 메서드
@Service
public class TokenProvider {
    // 토큰 시크릿 키
    private static final String SECRET_KEY = "GACHON_WEBDB";

    // 토큰 발급
    public String createToken(UserDTO params) {
        Date expiryDate = Date.from(
                Instant.now()
                        .plus(1, ChronoUnit.DAYS));
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .setSubject(params.getUsername()) // sub
                .setIssuer("WebDB Bamboo")
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .compact();
    }

    // 토큰을 통해 검증하고 사용자 이름을 추출하는 메서드
    public String validateAndGetUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}