package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDetail extends AbstractPage {

    @FindBy(xpath = "//a[text()=\"Settings\"]")
    private WebElement settingsTab;

    @FindBy(css = "a[data-method=\"delete\"]")
    private WebElement deleteAccountLink;

    @FindBy(css = "li[class=\"notice\"]")
    private WebElement message;

    @FindBy(css = "a[href=\"/accounts\"]")
    private WebElement accountLink;

    private static final String ACCOUNT_NAME = "//div[text()='%s']";

    public void clickSettingsTab() {
        action.click(settingsTab);
    }

    public void clickDeleteAccountLink(){
        action.click(deleteAccountLink);
        action.clickPopup();
    }

    public String getAccountMessageDeleted() {
        return action.getText(message);
    }

    public boolean isAccountVisible(String accountName) {
        action.click(accountLink);
        return action.isElementVisible(By.xpath(String.format(ACCOUNT_NAME, accountName)));
    }
}
