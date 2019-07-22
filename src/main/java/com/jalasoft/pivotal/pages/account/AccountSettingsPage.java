package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSettingsPage extends AbstractPage {

        @FindBy(css = ".create_account_button")
        private WebElement createAccount;

        @FindBy (xpath = "//div[text()='%s']/ancestor::div[@class='header']/descendant::a[text()='Manage Account']")
        private WebElement manageAccount;

        public AccountModal clickCreateAccount(){
            action.click(createAccount);
            return new AccountModal();
        }
}
