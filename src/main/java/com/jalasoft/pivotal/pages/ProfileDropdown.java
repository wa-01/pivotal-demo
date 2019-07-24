package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.pages.Account.UserAccounts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileDropdown extends AbstractPage{
    //Added for WEB-AUT evaluation jose colina
    @FindBy (css = "a[class *= 'Dropdown__option'][href = '/accounts']")
    private WebElement accountDropDownOption;

    private WebDriver driver;

    public ProfileDropdown(WebDriver driver) {
        this.driver = driver;
    }

    public String getAvatarName() {
        return driver.findElement(By.cssSelector(".AvatarDetails__name")).getText();
    }

    //Added for WEB-AUT evaluation jose colina
    public UserAccounts clickAccountOption(){
        action.click(accountDropDownOption);
        return new UserAccounts();
    }
}
