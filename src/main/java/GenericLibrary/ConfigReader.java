package GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties props = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("D:\\project1\\Project1\\src\\main\\java\\GenericLibrary\\Config.properties");
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load config.properties", e);
        }
    }

    // 1. Generic method to fetch value for any key
    public static String get(String key) {
        return props.getProperty(key);
    }

    // 2. Optional helper to map environments to URLs
    public static String getEnvironmentURL(String env) {
        return switch (env.toLowerCase()) {
            case "qa" -> "https://qa.yourapp.com";
            case "staging" -> "https://staging.yourapp.com";
            case "prod" -> "https://www.yourapp.com";
            default -> throw new IllegalArgumentException("Invalid environment: " + env);
        };
    }
}
