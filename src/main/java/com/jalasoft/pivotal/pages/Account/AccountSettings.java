package com.jalasoft.pivotal.pages.Account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSettings extends AbstractPage {
    @FindBy (css = "[data-method='delete']")
    private WebElement deleteAccountLink;

    public void deleteAccount(){
        action.click(deleteAccountLink);
        action.acceptAlertMessage();
    }
}
