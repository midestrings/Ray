package com.ray.vehicle.util;

import java.util.List;
import java.util.stream.Stream;

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
}
