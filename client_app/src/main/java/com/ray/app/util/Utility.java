package com.ray.app.util;

import com.ray.app.grpc.DateTime;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public final class Utility {
    private Utility() {
    }

    private final static Logger LOG = LogManager.getLogger(Utility.class.getName());
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public static boolean isEmpty(String string) {
        return string == null || string.isBlank();
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
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
        stage.getIcons().add(new Image(Objects.requireNonNull(Utility.class.getResourceAsStream("/assets/icons/icon.png"))));
    }

    public static boolean getBooleanValue(String value) {
        return value != null && (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("yes"));
    }

    public static Date getDate(DateTime dateTime) {
        try {
            var calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, dateTime.getYear());
            calendar.set(Calendar.MONTH, dateTime.getMonth());
            calendar.set(Calendar.DAY_OF_MONTH, dateTime.getDay());
            calendar.set(Calendar.HOUR, dateTime.getHour());
            calendar.set(Calendar.MINUTE, dateTime.getMinute());
            calendar.set(Calendar.SECOND, dateTime.getSecond());
            return calendar.getTime();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }

    public static Date getDate(String dateString) {
        try {
            return dateString != null ? new SimpleDateFormat("dd-MM-yyyy").parse(dateString) : null;
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date getDate(com.ray.app.grpc.Date date) {
        try {
            var calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, date.getYear());
            calendar.set(Calendar.MONTH, date.getMonth());
            calendar.set(Calendar.DAY_OF_MONTH, date.getDay());
            return calendar.getTime();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }

    public static DateTime getDateTime(Date date) {
        if (date == null) return DateTime.getDefaultInstance();
        var calendar = Calendar.getInstance();
        calendar.setTime(date);
        return DateTime.newBuilder()
                .setYear(calendar.get(Calendar.YEAR))
                .setMonth(calendar.get(Calendar.MONTH))
                .setDay(calendar.get(Calendar.DAY_OF_MONTH))
                .setHour(calendar.get(Calendar.HOUR))
                .setMinute(calendar.get(Calendar.MINUTE))
                .setSecond(calendar.get(Calendar.SECOND))
                .build();
    }

    public static com.ray.app.grpc.Date getProtoDate(Date date) {
        if (date == null) return com.ray.app.grpc.Date.getDefaultInstance();
        var calendar = Calendar.getInstance();
        calendar.setTime(date);
        return com.ray.app.grpc.Date.newBuilder()
                .setYear(calendar.get(Calendar.YEAR))
                .setMonth(calendar.get(Calendar.MONTH))
                .setDay(calendar.get(Calendar.DAY_OF_MONTH))
                .build();
    }

    public static boolean isInvalidEmail(String email) {
        String regex = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return email == null || !email.matches(regex);
    }


    public static boolean isInvalidPassword(String password) {
        return password == null || password.length() < 8;
    }

}
