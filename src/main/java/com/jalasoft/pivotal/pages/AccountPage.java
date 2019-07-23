package com.jalasoft.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class AccountPage extends AbstractPage {

    @FindBy(css = "#new_account_link")
    private WebElement createAccountLink;

    @FindBy(css = "input[data-aid=\"input\"]")
    private WebElement accountNameInput;

    @FindBy(css = "button[class=\"zWDds__Button pvXpn__Button--positive\"]")
    private WebElement createAccountButton;

    public void createAccount(Map<String, String> data) {
        action.click(createAccountLink);
        action.setValue(accountNameInput,data.get("AccountName"));
        action.click(createAccountButton);
    }
}
