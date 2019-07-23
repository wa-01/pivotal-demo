package com.jalasoft.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDetail extends AbstractPage {

    @FindBy(css= ".account_name")
    private WebElement accountName;

    public String getAccountName() {
        return action.getText(accountName);
    }

}
