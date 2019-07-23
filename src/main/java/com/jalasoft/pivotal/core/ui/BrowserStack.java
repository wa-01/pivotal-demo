package com.jalasoft.pivotal.core.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStack extends AbstractDriver {

    public static final String USERNAME = "carledriss1";
    public static final String AUTOMATE_KEY = "SUcFSGH3Y6kzYvxHrxfF";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    @Override
    WebDriver initDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "76.0 beta");
        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Mojave");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("name", "Bstack-[Java] Sample Test");

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
