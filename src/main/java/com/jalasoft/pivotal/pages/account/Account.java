package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account extends AbstractPage {

    private static final String MANAGE_ACCOUNT_BUTTON_XPATH = "//a[text()='Manage Account']/ancestor::div[@class='header']//div[text()='%s']";
    private static final String ACCOUNT_NAME_XPATH = "//div[@class='header']//div[text()='%s']";

    @FindBy(css = "#new_account_link")
    private WebElement newAccountLink;

    @FindBy(css = "#notice")
    private WebElement noticeBanner;

    @FindBy(css = "div[class='accounts_list owner'] div[class='name']")
    private WebElement accountName;

    public ModalContent clickNewAccountLink() {
        action.click(newAccountLink);
        return new ModalContent();
    }

    public ManageAccount clickManageAccount(String accountName) {
        String manageAccountButtonLocator = String.format(MANAGE_ACCOUNT_BUTTON_XPATH, accountName);
        action.click(By.xpath(manageAccountButtonLocator));
        return new ManageAccount();
    }

    public String getNoticeBanner() {
        return action.getText(noticeBanner);
    }

    public boolean findAccountOwnName(String accountName){
        String accountLocatorName = String.format(ACCOUNT_NAME_XPATH, accountName);
        return driver.findElements(By.xpath(accountLocatorName)).size() > 0;
    }
}
