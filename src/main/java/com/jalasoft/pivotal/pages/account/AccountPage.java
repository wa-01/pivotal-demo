package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import cucumber.api.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    @FindBy(css = ".create_account_button")
    private WebElement createAccount;

    @FindBy (css = "a[href=\"/accounts\"]")
    private WebElement accountsLink;

    private String manageAccount = "//div[text()='%s']/ancestor::div[@class='header']/descendant::a[text()='Manage Account']";

    @FindBy (css = "#notice")
    private WebElement notice;

    public AccountModal clickCreateAccount(){
        action.click(createAccount);
        return new AccountModal();
    }

    public void clickAccountsLink(){
        action.click(accountsLink);
    }

    public AccountSettingsPage clickManageAccount(String accountName){
        action.click(By.xpath(String.format(manageAccount,accountName)));
        return new AccountSettingsPage();
    }

    public String getAccountDeleteMessage(){
        String message = notice.getText();
        return message;
    }
}
