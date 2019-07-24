package com.jalasoft.pivotal.core.ui;

import java.util.concurrent.TimeUnit;

import com.jalasoft.pivotal.core.Environment;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static DriverManager ourInstance = new DriverManager();

    public static DriverManager getInstance() {
        return ourInstance;
    }

    private WebDriver driver;


    private DriverManager() {
        String browser = Environment.getInstance().getValue("$['browser']");
        driver = DriverFactory.getDriver(browser);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
