package com.ray.user.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import static com.ray.user.UserInfoServer.getProperties;

public final class Utility {
    private Utility() {}

    public static boolean isInvalidEmail(String email) {
        String regex = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return email == null || !email.matches(regex);
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isBlank();
    }

    public static boolean isInvalidPassword(String password) {
        return password == null || password.length() < 8;
    }

    public static String generateToken() {
        var secret = getProperties().getProperty("jwt_secret_key");

        var hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS256.getJcaName());
        var now = Instant.now();
        return Jwts.builder()
                .setSubject("user_service")
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(5L, ChronoUnit.MINUTES)))
                .signWith(hmacKey)
                .compact();
    }
}
