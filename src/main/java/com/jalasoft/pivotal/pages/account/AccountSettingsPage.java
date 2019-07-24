package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSettingsPage extends AbstractPage {

    @FindBy(css = ".button[href*=\"settings\"]")
    private WebElement accountSettingButton;

    @FindBy(css = "[data-method=\"delete\"]")
    private WebElement deleteAccountLink;

    @FindBy(css = "#notice")
    private WebElement successDeleteMessage;

    @FindBy(css = "a[href=\"/accounts\"]")
    private WebElement accountsLink;

    private static final String ACCOUNT_NAME = "//div[text()='%s']";

    public void clickAccountSettings() {
        action.click(accountSettingButton);
    }

    public void clickDeleteAccountLink() {
        action.click(deleteAccountLink);
    }

    public void AcceptPopUp() {
        action.acceptPopupChrome();
    }

    public String getSuccessMessage() {
        return action.getText(successDeleteMessage);
    }

    public boolean isAccountNamePresent(String accName) {
    action.click(accountsLink);
        return action.isElementVisible(By.xpath(String.format(ACCOUNT_NAME, accName)));
    }
}
