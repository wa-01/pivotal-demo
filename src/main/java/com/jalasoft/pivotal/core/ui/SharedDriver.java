package com.jalasoft.pivotal.core.ui;

import com.jalasoft.pivotal.core.Environment;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SharedDriver {

    public SharedDriver() {
        if (DriverFactory.getDriver() == null) {
            String browser = Environment.getInstance().getValue("$['browser']");
            WebDriver driver = BrowserFactory.getDriver(browser);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            DriverFactory.addDriver(driver);
        }
    }
}
