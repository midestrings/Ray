package com.ray.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class UserInfoServer {
    private static final Properties properties = new Properties();

    public static void main( String[] args ) {
        loadConfig(args);

    }

    private static void loadConfig(String[] args) {
        var propertyFile = "/application.properties";
        if (args.length > 0 && args[0].equalsIgnoreCase("dev")) {
            propertyFile = "/application-dev.properties";
        }
        try (InputStream is = UserInfoServer.class.getResourceAsStream(propertyFile)) {
            properties.load(is);
            System.setProperties(properties);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
