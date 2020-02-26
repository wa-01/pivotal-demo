package com.jalasoft.pivotal.core.ui;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public final class DriverFactory {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    // To quit the drivers and browsers at the end only.
    private static List<WebDriver> storedDrivers = new ArrayList<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> storedDrivers.forEach(WebDriver::quit)));
    }

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return drivers.get();
    }

    /**
     * Adding driver.
     *
     * @param driver Webdriver.
     */
    public static void addDriver(final WebDriver driver) {
        storedDrivers.add(driver);
        drivers.set(driver);
    }
}
