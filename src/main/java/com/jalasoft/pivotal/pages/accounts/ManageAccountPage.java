package com.jalasoft.pivotal.pages.accounts;/*
 * @autor: mauricioramirez
 * Project: pivotal-demo
 * Package: com.jalasoft.pivotal.pages.accounts
 * Version: 1.0
 */

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class ManageAccountPage extends AbstractPage {

    @FindBy(css = "h2.account_name > span")
    private WebElement getAccountNameTitle;

//    @FindBy(xpath = "//div[contains(@class, \"subnav\")]/descendant::a[contains(text(), \"Settings\")]")
    @FindBy(xpath = "//div[contains(@class, \"subnav\")]/descendant::a[contains(@href, \"settings\")]")
    private WebElement settingsSubnavButton;

    @FindBy(css = "#account_name")
    private WebElement accountNameTextField;

    @FindBy(css = "a[data-method=\"delete\"]")
    private WebElement deleteAccountLink;

    public ManageAccountPage clickSettingsButton() {
        action.click(settingsSubnavButton);

        return this;
    }

    public String getAccountNameTextField() {
        return action.getText(accountNameTextField);
    }

    public AccountsPage deleteAccount() {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        action.click(deleteAccountLink);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        action.clickAlertAccept();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return new AccountsPage();
    }
}
