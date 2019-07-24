package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountForm extends AbstractPage {

    @FindBy(css = "input[data-aid='input']")
    private WebElement accountNameTextField;

    @FindBy(css = "button[data-aid='FormModal__submit']")
    private WebElement createButton;

    public void setAccountName(String accountName){
        action.setValue(accountNameTextField, accountName);
    }

    public AccountPlansBilling clickCreateButton(){
        // The browser goes always to the Account's Plan Billing page once the account is created.
        action.click(createButton);
        return new AccountPlansBilling();
    }
}
