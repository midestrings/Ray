package com.ray.user.util;

import java.util.List;

public final class Role {
    private Role() {};

    public static final String User_Client = "user_client";
    public static final String User_Vendor = "user_vendor";
    public static final String User_Admin = "user_admin";
    public static final List<String> roles = List.of(User_Admin, User_Client, User_Vendor);
}
