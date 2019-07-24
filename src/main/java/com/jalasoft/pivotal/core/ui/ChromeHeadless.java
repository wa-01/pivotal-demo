package com.jalasoft.pivotal.core.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadless extends AbstractDriver{
    @Override
    WebDriver initDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        //options.addArguments("--start-maximized");
        options.addArguments("headless");
        return new ChromeDriver(options);
    }
}
