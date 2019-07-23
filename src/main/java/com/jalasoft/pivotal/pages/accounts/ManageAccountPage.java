package com.jalasoft.pivotal.pages.accounts;/*
 * @autor: mauricioramirez
 * Project: pivotal-demo
 * Package: com.jalasoft.pivotal.pages.accounts
 * Version: 1.0
 */

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageAccountPage extends AbstractPage {

    @FindBy(css = "h2.account_name > span")
    private WebElement getAccountNameTitle;

//    @FindBy(css = "//div[contains(@class, \"subnav\")]/descendant::a[contains(text(), \"Settings\")]")
    @FindBy(xpath = "//div[contains(@class, \"subnav\")]/descendant::a[contains(@href, \"settings\")]")
    private WebElement settingsSubnavButton;

    @FindBy(css = "#account_name")
    private WebElement accountNameTextField;

    public ManageAccountPage clickSettingsButton() {
        action.click(settingsSubnavButton);

        return this;
    }

    public String getAccountNameTextField() {
        return action.getText(accountNameTextField);
    }
}
