package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPane extends AbstractPage {

    @FindBy (xpath = "//a[text()='delete this account']")
    private WebElement deleteAccount;

    public AccountSettingsPage deleteAccount(){
        action.click(deleteAccount);
        driver.switchTo().alert().accept();
        return new AccountSettingsPage();
    }
}

