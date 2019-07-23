package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class AccountPage extends AbstractPage {

    private static final String OPTION_ACCOUNT_MANAGE_XPATH = "//div[@class='header']/descendant::div[text()='%s']/preceding::a[contains(@id,'manage')]";

    @FindBy(css = "#new_account_link")
    private WebElement createAccountLink;

    @FindBy(css = "input[data-aid=\"input\"]")
    private WebElement accountNameInput;

    @FindBy(css = "button[class=\"zWDds__Button pvXpn__Button--positive\"]")
    private WebElement createAccountButton;


    public ManageSpecificAccountPage createAccount(Map<String, String> data) {
        action.click(createAccountLink);
        action.setValue(accountNameInput,data.get("AccountName"));
        action.click(createAccountButton);
        return new ManageSpecificAccountPage();
    }

    public ManageSpecificAccountPage goToAccountSpecificSettings(String accountName) {
        String accountSpecificManageLink = String.format(OPTION_ACCOUNT_MANAGE_XPATH,accountName);
        action.click(By.xpath(accountSpecificManageLink));
        return new ManageSpecificAccountPage();
    }

    public void isAccountListed(String accountName) {
        
    }
}
