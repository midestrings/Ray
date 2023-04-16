package com.ray.schedule.util;

import com.ray.schedule.grpc.DateTime;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static com.ray.schedule.ReservationServer.getProperties;

public final class Utility {
    private Utility() {}

    public static boolean isEmpty(String string) {
        return string == null || string.isBlank();
    }

    public static Date getDate(DateTime dateTime) {
        var calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, dateTime.getYear());
        calendar.set(Calendar.MONTH, dateTime.getMonth());
        calendar.set(Calendar.DAY_OF_MONTH, dateTime.getDay());
        calendar.set(Calendar.HOUR, dateTime.getHour());
        calendar.set(Calendar.MINUTE, dateTime.getMonth());
        calendar.set(Calendar.SECOND, dateTime.getSecond());
        return calendar.getTime();
    }

    public static DateTime getDateTime(Date date) {
        var calendar = Calendar.getInstance();
        calendar.setTime(date);
        return DateTime.newBuilder()
                .setYear(calendar.get(Calendar.YEAR))
                .setMonth(calendar.get(Calendar.MONTH))
                .setDay(calendar.get(Calendar.DAY_OF_MONTH))
                .setHour(calendar.get(Calendar.HOUR))
                .setMinute(calendar.get(Calendar.MINUTE))
                .setSecond(calendar.get(Calendar.SECOND))
                .build();
    }

    public static String generateToken() {
        var secret = getProperties().getProperty("jwt_secret_key");

        var hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS256.getJcaName());
        var now = Instant.now();
        return Jwts.builder()
                .setSubject("schedule_service")
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(5L, ChronoUnit.MINUTES)))
                .signWith(hmacKey)
                .compact();
    }}
