package com.jalasoft.pivotal.pages.accounts;/*
 * @autor: mauricioramirez
 * Project: pivotal-demo
 * Package: com.jalasoft.pivotal.pages
 * Version: 1.0
 */

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsPage extends AbstractPage {

    @FindBy(css = "#new_account_link")
    private WebElement newAccountButton;

    public NewAccountForm clickNewAccountButton() {
        action.click(newAccountButton);

        return new NewAccountForm();
    }

}
