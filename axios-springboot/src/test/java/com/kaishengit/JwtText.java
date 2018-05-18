package com.kaishengit;

import com.kaishengit.utiil.JwtUtil;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class JwtText {

    private JwtUtil jwtUtil = new JwtUtil();

    @Test
    public void createToken() throws UnsupportedEncodingException {

        System.out.println(jwtUtil.createToken(1001,"123123"));

        /*Algorithm algorithm = Algorithm.HMAC384("123123");
        String token = JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis()+1000))
                .withClaim("userId",1000)
                .sign(algorithm);
        System.out.println(token);*/
    }

    @Test
    public void verifyToken() throws UnsupportedEncodingException {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJleHAiOjE1MjkyNDU4MDIsInVzZXJJZCI6MTAwMX0.NzY8y4A6W3PJUrpNxfPAtJCreXpvceUfNYElrwb0H7cfyZt9uzqm6e1npWz7xWT4";
        jwtUtil.verifyToken(token,"123123",1001);


        /*String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJleHAiOjE1MjY2MDc3MjIsInVzZXJJZCI6MTAwMH0._efDZADJ6LzFhfui_iHpyxywPNaCffaPDsjeoAG97xGO3TXKy7LLkGhI68ZskSS8";
        Algorithm algorithm = Algorithm.HMAC384("123123");
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        jwtVerifier.verify(token);
        System.out.println("ok");*/
    }

    @Test
    public void getUserId() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJleHAiOjE1MjkyNDU4MDIsInVzZXJJZCI6MTAwMX0.NzY8y4A6W3PJUrpNxfPAtJCreXpvceUfNYElrwb0H7cfyZt9uzqm6e1npWz7xWT4";
        Integer id = jwtUtil.getUserIdFromToken(token);
        System.out.println(id);
        /*String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJleHAiOjE1MjY2MDc3MjIsInVzZXJJZCI6MTAwMH0._efDZADJ6LzFhfui_iHpyxywPNaCffaPDsjeoAG97xGO3TXKy7LLkGhI68ZskSS8";
        DecodedJWT decodedJWT = JWT.decode(token);
        long id = decodedJWT.getClaim("userId").asLong();
        System.out.println(id);*/
    }

}
