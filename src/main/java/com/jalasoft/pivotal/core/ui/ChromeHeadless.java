package com.jalasoft.pivotal.core.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadless extends AbstractDriver{
    @Override
    WebDriver initDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("disable-infobars"); // disabling infobars
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        return new ChromeDriver(options);
    }
}
