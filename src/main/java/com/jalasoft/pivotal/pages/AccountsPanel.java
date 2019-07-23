package com.jalasoft.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsPanel extends AbstractPage {

    @FindBy(css = ".create_account_button")
    private WebElement createAccountButton;

    @FindBy(css = ".tc-form__input")
    private WebElement accountNameTextField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    public AccountDetail createAccount(String accountName){
        action.click(createAccountButton);
        action.setValue(accountNameTextField, accountName);
        action.click(submitButton);
        return new AccountDetail();
    }
}
