package com.jalasoft.pivotal.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account extends AbstractPage {

    @FindBy(css = "#new_account_link")
    private WebElement createAccountButton;

    @FindBy(css = "input[data-aid=\"input\"]")
    private WebElement accountInputText;

    @FindBy(css = "button[class=\"zWDds__Button pvXpn__Button--positive\"]")
    private WebElement createButton;

    @FindBy(xpath = "//a[text()='delete this account']")
    private WebElement deleteLink;

    @FindBy(css = "#notice")
    private WebElement noticeMsg;

    private String accountTabSelector = "//a[text()='%s']";

    public void goToAccountsPage(){
        driver.get("https://www.pivotaltracker.com/accounts");
    }

    public void createAccount(String newAccount){
        action.click(createAccountButton);
        action.setValue(accountInputText, newAccount);
        action.click(createButton);
    }

    public void clickOnTab(String tabName) {
        action.click(By.xpath(String.format(accountTabSelector, tabName)));
    }

    public void clickDeleteAccount() {
        action.click(deleteLink);
    }

    public void confirmAcoountDeletion() {
        driver.switchTo().alert().accept();
    }

    public String getAccountMessageDeletion() {
        return action.getText(noticeMsg);
    }
}
