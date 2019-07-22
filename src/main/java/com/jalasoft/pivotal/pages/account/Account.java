package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account extends AbstractPage {

    private static final String MANAGE_ACCOUNT_BUTTON_XPATH = "//*[text()='Manage Account']/ancestor::div[@class='header']//div[text()='%s']";

    @FindBy(css = "#new_account_link")
    private WebElement newAccountLink;

    @FindBy(css = "#notice")
    private WebElement noticeBanner;

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
}
