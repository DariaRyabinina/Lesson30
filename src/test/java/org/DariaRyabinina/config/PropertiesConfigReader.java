package org.DariaRyabinina.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfigReader implements ConfigReader {
    private final Properties properties = new Properties();

    public PropertiesConfigReader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = contextClassLoader.getResourceAsStream("config/config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Метод вазван в неправильное время");
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
