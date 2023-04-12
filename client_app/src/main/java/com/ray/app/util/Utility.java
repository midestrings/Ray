package com.ray.app.util;

import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Utility {
    private Utility() {}
    private static final String ICON_IMAGE_LOC = "/resources/icons/icon.png";
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public static boolean isEmpty(String string) {
        return string == null || string.isBlank();
    }

    public static String formatDateTimeString(Date date) {
        return DATE_TIME_FORMAT.format(date);
    }

    public static String formatDateTimeString(Long time) {
        return DATE_TIME_FORMAT.format(new Date(time));
    }

    public static String getDateString(Date date) {
        return DATE_FORMAT.format(date);
    }

    public static void setStageIcon(Stage stage) {
        stage.getIcons().add(new Image(ICON_IMAGE_LOC));
    }

    public static boolean getBooleanValue(String value) {
        return value != null && (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("yes"));
    }

}
