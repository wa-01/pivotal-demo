package com.jalasoft.pivotal.core.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {

    private static final Map<String, Supplier<AbstractDriver>> DRIVERS = new HashMap<>();
    static {
        DRIVERS.put("chrome", Chrome::new);
        DRIVERS.put("firefox", Firefox::new);
        DRIVERS.put("remote", BrowserStack::new);
        DRIVERS.put("docker", Docker::new);
        DRIVERS.put("headless", ChromeHeadless::new);
    }

    public static WebDriver getDriver(String browser) {
		return DRIVERS.getOrDefault(browser, Chrome::new).get().initDriver();
    }
}
