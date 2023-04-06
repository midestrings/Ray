package com.ray.email;

import java.util.stream.Stream;

public final class Utility {
    private Utility() {}

    public static boolean isEmpty(String string) {
        return string == null || string.isBlank();
    }
}
