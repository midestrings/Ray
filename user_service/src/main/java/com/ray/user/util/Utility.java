package com.ray.user.util;

public final class Utility {
    private Utility() {}

    public static boolean isInvalidEmail(String email) {
        String regex = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return email == null || !email.matches(regex);
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isBlank();
    }

    public static boolean isInvalidPassword(String password) {
        return password == null || password.length() < 8;
    }
}
