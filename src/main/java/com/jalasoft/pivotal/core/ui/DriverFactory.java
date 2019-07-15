package com.jalasoft.pivotal.core.ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    private static final Map<String, Supplier<AbstractDriver>> DRIVERS = new HashMap<>();
    static {
        DRIVERS.put("chrome", Chrome::new);
        DRIVERS.put("firefox", Firefox::new);
        DRIVERS.put("remote", BrowserStack::new);
        DRIVERS.put("docker", Docker::new);
        DRIVERS.put("headless", ChromeHeadless::new);
    }

    public static WebDriver getDriver(String browser) {
		return DRIVERS.get(browser).get().initDriver();
    }
}
