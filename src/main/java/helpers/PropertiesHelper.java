package helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {
    private static PropertiesHelper instance;
    private final Properties props = new Properties();

    private PropertiesHelper() {
        try {
            String env = System.getProperty("env", "prod");
            String path = env + ".properties";
            InputStream input = getClass().getClassLoader().getResourceAsStream(path);
            if (input == null) {
                throw new RuntimeException("Config file not found: " + path);
            }
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    public static synchronized PropertiesHelper getInstance() {
        if (instance == null) {
            instance = new PropertiesHelper();
        }
        return instance;
    }

    public String getBrowser() {
        return props.getProperty("browser");
    }

    public String getBaseUrl() {
        return props.getProperty("base.url");
    }
}
