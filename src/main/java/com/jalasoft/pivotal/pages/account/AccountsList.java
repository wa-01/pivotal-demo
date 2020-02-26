package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsList extends AbstractPage {

    @FindBy(css = "#new_account_link")
    private WebElement createAccountButton;

    @FindBy(css = "input[data-aid='input']")
    private WebElement accountNameTxt;

    @FindBy(css = "h2[class='account_name']")
    private WebElement accountNameLabel;

    @FindBy(css = "#notice")
    private WebElement confirmationMessage;

    private String anchorByText = "//a[text()='%s']";

    public void clickMenuLink(String menu) {
        String link = String.format("//a[@href='/profile']/following-sibling::a[@href='/%s']", menu);
        action.click(By.xpath(link));
    }

    public void createAccountClick() {
        action.click(createAccountButton);
    }

    public void setAccountName(String accountName) {
        action.setValue(accountNameTxt, accountName);
    }

    public void createClick() {
        action.click(By.xpath("//button[text()='Create']"));
    }

    public String getAccountNameLabel() {
        return action.getText(accountNameLabel);
    }

    public void clickOnSettingsTab(String tabName) {
        action.click(By.xpath(String.format(anchorByText, tabName)));
    }

    public void deleteAccount(String text) {
        action.click(By.xpath(String.format(anchorByText, text)));
    }

    public void confirmDelete() {
        driver.switchTo().alert().accept();
    }

    public String getConfirmationMessage() {
        return action.getText(confirmationMessage);
    }

    public boolean isAccountVisible(String accountName) {
        return action.isElementVisible(By.xpath(String.format("//div[text()='%s']", accountName)));
    }
}
