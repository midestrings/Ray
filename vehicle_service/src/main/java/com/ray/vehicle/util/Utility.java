package com.ray.vehicle.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static com.ray.vehicle.VehicleServer.getProperties;

public final class Utility {
    private Utility() {}

    public static boolean isInvalidEmail(String email) {
        String regex = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return email == null || !email.matches(regex);
    }

    public static boolean isValidPlateNumber(String plateNumber) {
        Stream<String> regexes = Stream.of("^[A-Z]{2}-\\d{4}-[A-Z]{1,2}$");
        return plateNumber != null && regexes.anyMatch(plateNumber::matches);
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isBlank();
    }

    public static String generateToken() {
        var secret = getProperties().getProperty("jwt_secret_key");

        var hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS256.getJcaName());
        var now = Instant.now();
        return Jwts.builder()
                .setSubject("vehicle_service")
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(5L, ChronoUnit.MINUTES)))
                .signWith(hmacKey)
                .compact();
    }
}
