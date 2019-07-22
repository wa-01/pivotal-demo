package com.jalasoft.pivotal.pages.Account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewAccount extends AbstractPage {
    @FindBy (css = ".tc-form__input")
    private WebElement accountName;

    @FindBy (css = "[class*=Button--positive]")
    private WebElement createButton;

    @FindBy (css = "[class*=Button--open]")
    private WebElement cancelButton;

    public void createAccount(String accountName){
        action.setValue(this.accountName, accountName);
        action.click(createButton);
    }
}
