package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * класс который отвечает за считывание пропертей из файла, синглтон
 */
public final class PropertiesUtil {

    public static final Properties PROPERTIES = new Properties();

    private PropertiesUtil() {
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    static {
        loadUtil();
    }

    private static void loadUtil() {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
