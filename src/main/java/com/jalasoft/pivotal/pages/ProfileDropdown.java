package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileDropdown extends AbstractPage{
    // Locator for dropDown options: Profile, Accounts, Reports & Analytics
    private String OPTIONS = "//div[@data-aid='Dropdown__tabstop']/child::a[text()='%s']";

    @FindBy(css = ".AvatarDetails__name")
    private WebElement avatarName;

    public String getAvatarName() {
        return action.getText(avatarName);
    }

    public void clickOption(String option) {
        // option can be: Profile, Accounts, Reports & Analytics
        driver.findElement(By.xpath(String.format(OPTIONS, option))).click();
    }

}
