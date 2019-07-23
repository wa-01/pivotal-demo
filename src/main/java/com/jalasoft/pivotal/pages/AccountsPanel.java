package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsPanel extends AbstractPage {

    @FindBy(css = ".create_account_button")
    private WebElement createAccountButton;

    @FindBy(css = ".tc-form__input")
    private WebElement accountNameTextField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

     private static final String ACCOUNT_NAME = "//div[@class='name' and text()='%s']";

     private static final String MANAGE_BUTTON = "/ancestor::div[@class='header']/child::a[contains(@id, 'manage')]";


    public AccountDetail createAccount(String accountName) {
        action.click(createAccountButton);
        action.setValue(accountNameTextField, accountName);
        action.click(submitButton);
        return new AccountDetail();
    }

    public boolean isAccountNameVisible(String accountName) {
        return action.isElementVisible(By.xpath(String.format(ACCOUNT_NAME, accountName)));
    }

    public AccountDetail selectAccount(String accountName){
        String accountManageButton = ACCOUNT_NAME+MANAGE_BUTTON;
        action.click(By.xpath(String.format(accountManageButton, accountName)));
        return new AccountDetail();
    }
}
