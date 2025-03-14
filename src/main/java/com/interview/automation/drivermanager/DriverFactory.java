package com.interview.automation.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DriverFactory {

    private static Map<String, Class<?>> browserMap;

    private static WebDriver driver;

    static {
        browserMap = new HashMap<>();
        browserMap.put("chrome", ChromeDriverManager.class);
        browserMap.put("firefox", FirefoxDriverManager.class);
        browserMap.put("edge", EdgeDriverManager.class);
        browserMap.put("safari", SafariDriverManager.class);
        browserMap.put("remote", RemoteDriverManager.class);
    }

    public static WebDriver getDriver() {
        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
            DriverManager manager = null;
            try {
                manager = (DriverManager) browserMap.get(getBrowser()).getDeclaredConstructor().newInstance();
                driver = manager.getDriver();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return driver;
    }

    private static String getBrowser() {
        Map<String, String> map = new HashMap<>();
        map.put("server", System.getProperty("web.server"));
        map.put("browser", System.getProperty("web.browser"));

        Properties properties = new Properties();
        try {
            properties.load(DriverFactory.class.getClassLoader().getResourceAsStream("web.properties"));
            map.put("browser", properties.getProperty("browser"));
            map.put("server", properties.getProperty("server"));
        } catch (IOException e) {
            throw new RuntimeException("Unable to find web.properties", e);
        }
        String server = map.get("server");
        String browser = map.get("browser");
        if (server != null && server.equalsIgnoreCase("remote")) {
            return server;
        }
        return browser;
    }
}
