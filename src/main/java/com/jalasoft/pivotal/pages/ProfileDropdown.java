package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileDropdown extends AbstractPage {

    @FindBy(css = ".AvatarDetails__name")
    private WebElement avatarDetailsName;

    // TODO: this can be div[data-aid="ProfileDropdown"]  a[href="/%s"] for a more dynamic selector
    @FindBy(css = "div[data-aid=\"ProfileDropdown\"]  a[href=\"/accounts\"]")
    private WebElement accountsButton;

    public String getAvatarName() {
        return action.getText(avatarDetailsName);
    }

    public void clickAccountsLink() {
        action.click(accountsButton);
    }

}
