package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.pages.account.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileDropdown extends AbstractPage{

    private WebDriver driver;

    @FindBy(css = "a[href='/accounts']")
    private WebElement accountsLink;

    @FindBy(css = ".AvatarDetails__name")
    private WebElement avatarDetailsName;

    public String getAvatarName() {
        return action.getText(avatarDetailsName);
    }

    public Account clickAccounts(){
        action.click(accountsLink);
        return new Account();
    }

}
