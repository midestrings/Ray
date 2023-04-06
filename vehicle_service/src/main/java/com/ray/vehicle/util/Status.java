package com.ray.vehicle.util;

import java.util.List;

public final class Status {
    private Status() {}

    public static final String Unverified = "unverified";
    public static final String Active = "active";
    public static final String Inactive = "inactive";
    public static final String Deleted = "deleted";
    public static final List<String> statuses = List.of(Unverified, Active, Inactive, Deleted);
}
