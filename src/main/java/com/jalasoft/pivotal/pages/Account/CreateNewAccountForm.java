package com.jalasoft.pivotal.pages.Account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewAccountForm extends AbstractPage {
    @FindBy (css = ".tc-form__input")
    private WebElement accountNameTextField;

    @FindBy (css = "[class*=Button--positive]")
    private WebElement createButton;

    @FindBy (css = "[class*=Button--open]")
    private WebElement cancelButton;

    public Account createAccount(String accountName){
        action.setValue(this.accountNameTextField, accountName);
        action.click(createButton);
        return new Account();
    }
}
