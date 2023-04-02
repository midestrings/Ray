package com.ray.user.entity;

import com.ray.user.grpc.UserRole;
import jakarta.persistence.*;

@Entity(name = "User_Role")
public class UserEntityRole {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String role;
    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "user_id", nullable = false)
    UserEntity user;

    public UserEntityRole() {}

    public UserEntityRole(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public static UserRole getUserRole(UserEntityRole role) {
        return UserRole.newBuilder()
                .setRole(role.role)
                .build();
    }

    public static UserEntityRole getInstance(UserRole role) {
        var entity = new UserEntityRole();
        entity.setRole(role.getRole());
        return entity;
    }
}