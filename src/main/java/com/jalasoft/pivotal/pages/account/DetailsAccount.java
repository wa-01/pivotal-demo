package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsAccount extends AbstractPage {
    private static String CSS_DETAILS_TITLE =".account_name";

    @FindBy (xpath = "//div[@class='accounts_list owner']")
    WebElement accountRow;

    public String getAccountName (){
        return action.getText(By.cssSelector(CSS_DETAILS_TITLE));
    }

    public void clickManageButton (String accountName){
        System.out.println(accountName);
    }
}
