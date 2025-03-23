package com.security.springsecurity.security;


//esta clase nos ayudara a crear los tokens

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {

    //crearemos una llave secreta, para poder firmar el token
    private final static String ACCES_TOKEN_SECRET = "G4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIz";

    //aqui se ha definido el tiempo de vida util del token
    private final static Integer ACCES_TOKEN_EXPIRATION_TIME = 120;


    public static String createToken(String username, String email) {
        long expirationTime = ACCES_TOKEN_EXPIRATION_TIME * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("username", username);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
                .compact();

    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCES_TOKEN_SECRET.getBytes())
                    .build().parseClaimsJws(token).getBody();

            String email = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());

        } catch (JwtException e) {
            return null;
        }


    }


}
