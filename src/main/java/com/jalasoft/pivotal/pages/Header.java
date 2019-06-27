package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

    private WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public ProfileDropdown clickProfileDropdown() {
        driver.findElement(By.cssSelector("div[data-aid=\"ProfileDropdown\"] > button")).click();
        return new ProfileDropdown(driver);
    }

    public ProjectStoryDropdown clickProjectStoryDropdown(){
        driver.findElement(By.cssSelector("button[class='expander undraggable']")).click();
        return new ProjectStoryDropdown(driver);
    }

    public String getStoryName() {
        return driver.findElement(By.cssSelector("textarea[name='story[name]']")).getText();
    }

    public String getStoryLabel(){
        return driver.findElement(By.cssSelector("div[data-aid='Label__Name']")).getText();
    }


    public String getStoryComment() {
        return driver.findElement(By.cssSelector("[data-aid='message'] p")).getText();
    }
}
