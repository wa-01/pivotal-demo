package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileDropdown {

    private WebDriver driver;

    public ProfileDropdown(WebDriver driver) {
        this.driver = driver;
    }

    public String getAvatarName() {
        return driver.findElement(By.cssSelector(".AvatarDetails__name")).getText();
    }

}
