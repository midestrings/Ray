package com.ray.user.entity;

import com.ray.user.grpc.Authentication;
import com.ray.user.grpc.Date;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Authentication")
public class AuthenticationEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 1024)
    private String token;
    @Column
    private String refreshToken;
    @Column
    private LocalDate refreshTokenExpiry;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime updatedAt;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public Integer getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public LocalDate getRefreshTokenExpiry() {
        return refreshTokenExpiry;
    }

    public void setRefreshTokenExpiry(LocalDate refreshTokenExpiry) {
        this.refreshTokenExpiry = refreshTokenExpiry;
    }

    public static Authentication getAuthentication(AuthenticationEntity auth) {
        return Authentication.newBuilder()
                .setToken(auth.token)
                .setRefreshToken(auth.refreshToken)
                .setRefreshTokenExpiry(auth.getDate())
                .build();
    }

    public Date getDate() {
        return Date.newBuilder()
                .setDay(refreshTokenExpiry.getDayOfMonth())
                .setMonth(refreshTokenExpiry.getMonthValue())
                .setYear(refreshTokenExpiry.getYear())
                .build();
    }
}