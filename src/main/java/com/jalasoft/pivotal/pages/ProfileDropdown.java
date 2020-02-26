package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.pages.account.AccountModal;
import com.jalasoft.pivotal.pages.account.AccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileDropdown extends AbstractPage{

    private WebDriver driver;

    @FindBy(xpath = "//a[@href='/reports']/preceding-sibling::a[@href='/accounts']")
    private WebElement accounts;

    public ProfileDropdown(WebDriver driver) {
        this.driver = driver;
    }
    public ProfileDropdown(){}

    public String getAvatarName() {
        return driver.findElement(By.cssSelector(".AvatarDetails__name")).getText();
    }

    public AccountPage clickAccounts(){
        action.click(accounts);
        return new AccountPage();
    }
}
