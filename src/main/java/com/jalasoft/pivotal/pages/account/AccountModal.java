package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountModal extends AbstractPage {

    @FindBy(css = "input[data-aid='input']")
    private WebElement accountName;

    @FindBy (css = "button[data-aid='FormModal__submit']")
    private WebElement createAccount;

    private void addAccountName(String name) {
        action.click(accountName);
        action.setValue(accountName, name);
    }

    public AccountPage saveNewAccount(String name){
        addAccountName(name);
        action.click(createAccount);
        driver.navigate().refresh();
        return new AccountPage();
    }
}
