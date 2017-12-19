package com.m2gi.movieMarket.api.property;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyHandler {

    private final Logger logger = Logger.getLogger(PropertyHandler.class.getName());
    private static final String PROPERTIES_FILE = "config.properties";
    private static volatile PropertyHandler instance = null;
    private Properties properties;

    private PropertyHandler() {
        try {
            this.properties = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(this.PROPERTIES_FILE);
            this.properties.load(inputStream);
            inputStream.close();
        } catch (Exception exception) {
            this.logger.log(Level.SEVERE, "Error while loading properties file", exception.getMessage());
        }
    }

    public final static PropertyHandler getInstance() {
        if (PropertyHandler.instance == null) {
            synchronized (PropertyHandler.class) {
                if (PropertyHandler.instance == null) {
                    PropertyHandler.instance = new PropertyHandler();
                }
            }
        }

        return PropertyHandler.instance;
    }

    public String getValue(String propertyKey) {
        return this.properties.getProperty(propertyKey);
    }
}
