package com.jalasoft.pivotal.pages.accounts;/*
 * @autor: mauricioramirez
 * Project: pivotal-demo
 * Package: com.jalasoft.pivotal.pages
 * Version: 1.0
 */

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsPage extends AbstractPage {

    @FindBy(css = "#new_account_link")
    private WebElement newAccountButton;

    private static final String MANAGE_ACCOUNT_BUTTON = "//div[text()=\"%s\"]/ancestor::div[contains(@class, \"card\")]" +
            "/descendant::a[contains(@id, \"manage_account_link\")]";

    private static final String ACCOUNT_CARD_TITLE = "//div[text()=\"%s\"]";

    public NewAccountForm clickNewAccountButton() {
        action.click(newAccountButton);

        return new NewAccountForm();
    }

    public ManageAccountPage clickManageAccountButton(String accountName) {
        String manageAccountButton = String.format(MANAGE_ACCOUNT_BUTTON, accountName);
        action.click(By.xpath(manageAccountButton));

        return new ManageAccountPage();
    }

    public String getAccountCardTitle(String accountTittle) {
        String accountCardTittle = String.format(ACCOUNT_CARD_TITLE, accountTittle);

        return action.getText(By.xpath(accountCardTittle));
    }

}
