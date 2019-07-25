package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends AbstractPage {

    @FindBy(css = "#new_account_link")
    WebElement buttonCreateAccount;

    private static String XPATH_MANAGE_BUTTON = "//div[text()='%s']/ancestor::div[@class='header']/descendant::a[contains(@id,'manage_account')]";

    @FindBy(xpath = "//div[text()='%s']/ancestor::div[@class='header']/descendant::a[contains(@id,'manage_account')]")
    WebElement accountRow;

    public AddAccount clickCreateProjectButton() {
        action.click(buttonCreateAccount);
        return new AddAccount();
    }


    public boolean accountDisplayed(String accountName) {
        return action.isElementVisible(By.xpath(String.format("//a[@data-aid='project-name' and text() = '%s']", accountName)));
    }

    public boolean accountIsNotDisplayed(String accountName) {
        return action.isElementVisible(By.xpath(String.format("//a[@data-aid='project-name' and text() = '%s']", accountName)));
    }
}
