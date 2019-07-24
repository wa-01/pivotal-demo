package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class AccountPage extends AbstractPage {


    private static final String LINK_TO_ACCOUNT_MANAGE_XPATH = "//div[@class='header']/descendant::a[contains(@id,'%s') and contains(@href,'accounts')]";

    private  static  final String ACCOUNT_FOUND_BY_ID = " //div[@class='accounts_list owner']/descendant::div[contains(@class,'%s')]";

    @FindBy(css = "#new_account_link")
    private WebElement createAccountLink;

    @FindBy(css = "input[data-aid=\"input\"]")
    private WebElement accountNameInput;

    @FindBy(css = "button[class=\"zWDds__Button pvXpn__Button--positive\"]")
    private WebElement createAccountButton;

    @FindBy(css = "#notice")
    private WebElement notificationMessage;


    public ManageSpecificAccountPage createAccount(Map<String, String> data) {
        action.click(createAccountLink);
        action.setValue(accountNameInput,data.get("AccountName"));
        action.click(createAccountButton);
        return new ManageSpecificAccountPage();
    }

    public ManageSpecificAccountPage goToAccountSpecificSettings(String accountID) {
        String accountSpecificManageLink = String.format(LINK_TO_ACCOUNT_MANAGE_XPATH,accountID);
        action.click(By.xpath(accountSpecificManageLink));
        return new ManageSpecificAccountPage();
    }

    public boolean isAccountListed(String accountID) {
        String accountFoundInList = String.format(ACCOUNT_FOUND_BY_ID,accountID);

       return driver.findElements(By.xpath(accountFoundInList)).size() > 0;

    }

    public boolean IsDeleteNotificationDisplayed(String notificationMessageExpected) {

        return notificationMessage.getText().equals(notificationMessageExpected);

    }
}
