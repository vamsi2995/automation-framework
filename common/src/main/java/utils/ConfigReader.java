package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties prop = new Properties();

    static {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();

            InputStream fis = loader.getResourceAsStream("config.properties");

            if (fis == null) {
                throw new RuntimeException("config.properties NOT FOUND");
            }

            prop.load(fis);

            System.out.println("CONFIG LOADED SUCCESSFULLY");
            System.out.println("API URL = " + prop.getProperty("api_base_url"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}