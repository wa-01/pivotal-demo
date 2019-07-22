package com.jalasoft.pivotal.pages.Account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accounts extends AbstractPage {
    //subnavButtons = "//ul[@class='buttons']/child::li[1]"
    @FindBy (css = ".create_account_button")
    private WebElement createButton;

    public void clickCreateButton(){
        action.click(createButton);
    }
}
