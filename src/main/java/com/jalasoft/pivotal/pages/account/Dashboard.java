package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends AbstractPage {

    @FindBy(css = "#new_account_link")
    WebElement buttonCreateAccount;

    public AddAccount clickCreateProjectButton() {
        action.click(buttonCreateAccount);
        return new AddAccount();
    }

    /**
     * modificar para que valide la nueva cuenta
     * @param accountName
     * @return
     */
    public boolean isProjectVisible(String accountName) {
        return action.isElementVisible(By.xpath(String.format("//a[@data-aid='project-name' and text() = '%s']", accountName)));
    }
}
