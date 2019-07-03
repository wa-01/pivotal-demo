package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CurrentBacklog extends AbstractPage {

    private WebDriver driver;

    public CurrentBacklog(WebDriver driver) {
        this.driver = driver;
    }

    public String getStoryName() {
        return driver.findElement(By.cssSelector(".tracker_markup")).getText();
    }

}
