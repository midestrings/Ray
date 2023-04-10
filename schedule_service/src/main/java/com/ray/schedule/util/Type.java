package com.ray.schedule.util;

import java.util.List;

public final class Type {
    private Type() {};

    public static final String Rent = "rent";
    public static final String Ride = "ride";
    public static final List<String> types = List.of(Rent, Ride);
}
