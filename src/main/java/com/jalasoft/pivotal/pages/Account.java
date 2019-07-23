package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account extends AbstractPage {
    private Header header = new Header();
    private String ACCOUNT_LABEL = "//div[@class='header']/descendant::div[text()='%s']";

    @FindBy(css = "a[href='/accounts']")
    private WebElement accountOption;

    @FindBy(css = ".create_account_button")
    private WebElement createAccount;

    @FindBy(css = ".tc-form__input")
    private WebElement AccountName;


    @FindBy(css = "button[class='zWDds__Button pvXpn__Button--positive']")
    private WebElement createAccountButton;


    @FindBy(css = "a[href*='/settings']")
    private WebElement tabSettings;

    @FindBy(css = "a[data-method = 'delete']")
    private WebElement linkDelete;

    @FindBy(css = "button[class *= \"Dropdown__button\"]")
    private WebElement profMenu;

    @FindBy (css = "#notice")
    private WebElement deletedMessage;

    public void clickUserMenu(){
        this.header.clickProfileDropdown();
    }

    public void clickAccountOption(){
        action.click(accountOption);
    }

    public void clickCreateAccount(){
        action.click(createAccount);
    }

    public void createAnAccount(String accountName){
        action.setValue(AccountName, accountName);
    }

    public void clickCreate(){
        action.click(createAccountButton);
    }

    public void clickSettings(){
        action.click(tabSettings);
    }

    public void clickLinkDelete(){
        action.click(linkDelete);
    }

    public void acceptPopup(){
        action.popUpAccept();
    }

    public void clickManageAccount (String AccountName) {
        String xpathManageAccount = "//div[@class='header']/descendant::div[text()='%s']/ancestor::h3/following-sibling::a[contains(@id,'manage_account_link')]";
        action.click(By.xpath(String.format(xpathManageAccount, AccountName)));
    }

    public void clickProfMenu(){
        action.click(profMenu);
    }

    public String getDeleteConfirmationMessage(){
        return action.getAttribute(deletedMessage, "innerText");
    }

    public boolean existAccount(String accountName){
        return action.isElementVisible(By.xpath(String.format(ACCOUNT_LABEL, accountName)));
    }
}
