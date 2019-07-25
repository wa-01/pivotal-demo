package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardAccount extends AbstractPage {

    private static String XPATH_MANAGE_BUTTON = "//div[text()='%s']/ancestor::div[@class='header']/descendant::a[contains(@id,'manage_account')]";

    private static String XPATH_DELETE_MESSAGE ="//li[@id='notice' and contains(text(),'%s')]";

    @FindBy(css = "#new_account_link")
    WebElement buttonCreateAccount;

    @FindBy(xpath = "//div[text()='%s']/ancestor::div[@class='header']/descendant::a[contains(@id,'manage_account')]")
    WebElement accountRow;

    public AddAccount clickCreateAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonCreateAccount));
        action.click(buttonCreateAccount);
        return new AddAccount();
    }

    public void clickManageButton(String accountName) {
        String manage_button = String.format(XPATH_MANAGE_BUTTON, accountName);
        action.click(By.xpath(manage_button));

    }

    public boolean accountDisplayed(String accountName) {
        return action.isElementVisible(By.xpath(String.format("//a[@data-aid='project-name' and text() = '%s']", accountName)));
    }

    public boolean accountIsNotDisplayed(String accountName) {
        return action.isElementVisible(By.xpath(String.format("//a[@data-aid='project-name' and text() = '%s']", accountName)));
    }

    public boolean deleteAccountMessageIsDisplayed(String accountName){
        return action.isElementVisible(By.xpath(String.format(XPATH_DELETE_MESSAGE, accountName)));

    }
}
