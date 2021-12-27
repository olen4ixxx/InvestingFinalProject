package io.olen4ixxx.investing.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesInitializer {
    private static final Logger logger = LogManager.getLogger();

    public static Properties initProperties() {
        Properties properties = new Properties();
        ClassLoader classLoader = PropertiesInitializer.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("application.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("Properties load failed", e);
        }
        return properties;
    }
}
