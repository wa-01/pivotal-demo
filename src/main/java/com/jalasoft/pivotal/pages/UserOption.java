package com.jalasoft.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserOption extends AbstractPage {

    @FindBy(css = ".tc_scrim")
    private WebElement UserMenu;

    @FindBy(css = "a[href='/accounts']")
    private WebElement AccountsOption;

    public void SelectAccount () {
        action.click(UserMenu);
        action.click(AccountsOption);
    }
}

