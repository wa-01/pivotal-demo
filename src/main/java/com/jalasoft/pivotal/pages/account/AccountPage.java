package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    @FindBy(css = "a[class=\"create_account_button\"]")
    private WebElement createAccountButton;

    @FindBy(css = "input[data-aid=\"input\"]")
    private WebElement accountNameTextField;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement createButton;

    @FindBy(css = "#main > div.content.clearfix > div.subnav.clearfix > ul > li:nth-child(2) > a")
    private WebElement accountSettingButton;

    public void clickCreateAccountButton() {
        action.click(createAccountButton);
    }

    public void setAccountField(String data) {
        action.setValue(accountNameTextField, data);
    }

     public AccountSettingsPage createAccount(String data) {
        setAccountField(data);
        action.click(createButton);
        return new AccountSettingsPage();
    }


}
