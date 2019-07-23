package com.jalasoft.pivotal.pages.Account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserAccounts extends AbstractPage {
   @FindBy (css = "#notice")
   private WebElement accountDeletedMessage;
   @FindBy (css = ".create_account_button")
   private WebElement createButton;

   private String MANAGE_ACCOUNT_BUTTON = "//div[@class='header']/descendant::div[text()='%s']/ancestor::h3/following-sibling::a[contains(@id,'manage_account_link')]";
   private String ACCOUNT_LABEL = "//div[@class='header']/descendant::div[text()='%s']";

    public CreateNewAccountForm clickCreateButton(){
        action.click(createButton);
        return new CreateNewAccountForm();
    }

    public void clickManageAccount(String accountName){
        action.click(By.xpath(String.format(MANAGE_ACCOUNT_BUTTON, accountName)));
    }

    public String getDeletedMessage(){
        return action.getAttribute(accountDeletedMessage, "innerText");
    }

    public boolean accountExists(String accountName) {
        return action.isElementVisible(By.xpath(String.format(ACCOUNT_LABEL, accountName)));
    }
}
