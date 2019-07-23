package com.jalasoft.pivotal.core.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Docker extends AbstractDriver {

    public static final String URL = "http://localhost:4444/wd/hub";


    @Override
    WebDriver initDriver() {

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(URL), new ChromeOptions());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
