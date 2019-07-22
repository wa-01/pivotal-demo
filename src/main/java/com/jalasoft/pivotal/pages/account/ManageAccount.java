package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageAccount extends AbstractPage {

    private static final String MANAGE_ACCOUNT_TAB_XPATH = "//a[contains(@class,'button') and text()='%s']";

    @FindBy(css = "a[data-method='delete']")
    private WebElement deleteThisAccountLink;

    public void clickManageAccountTab(String buttonName){
        String manageAccountTabLocator = String.format(MANAGE_ACCOUNT_TAB_XPATH, buttonName);
        action.click(By.xpath(manageAccountTabLocator));
    }

    public Account clickDeleteThisAccountLink(){
        action.click(deleteThisAccountLink);
        action.confirmDialog();
        return new Account();
    }

}
