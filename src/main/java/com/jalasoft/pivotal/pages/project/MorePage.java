package com.jalasoft.pivotal.pages.project;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MorePage extends AbstractPage {
    @FindBy (css = "#account_change_link")
    private WebElement changeAccountLink;

    private String ACCOUNT_OPTION = "//option[contains(text(),'%s')]";

    public void clickChangeAccount(){
        action.click(changeAccountLink);
    }

    public boolean accountIsPresent(String accountName){
        return action.isElementVisible(By.xpath(String.format(ACCOUNT_OPTION, accountName)));
    }
}
