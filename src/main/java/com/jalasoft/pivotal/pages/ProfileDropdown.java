package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.core.ui.WebDriverAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileDropdown extends AbstractPage {


    @FindBy(css = "a[href*='/accounts']")
    private WebElement accountLink;

    @FindBy(css = "AvatarDetails__name")
    private WebElement avatarName;


    public String getAvatarName() {
        return avatarName.getText();
    }

    public AccountPage goToAccountPage(){
        action.click(accountLink);
        return new AccountPage();

    }


}
