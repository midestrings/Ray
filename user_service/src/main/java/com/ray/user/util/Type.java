package com.ray.user.util;

import java.util.List;

public final class Type {
    private Type() {};

    public static final String Vendor = "vendor";
    public static final String Client = "client";
    public static final List<String> types = List.of(Vendor, Client);
}
