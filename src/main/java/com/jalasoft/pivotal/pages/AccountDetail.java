package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDetail extends AbstractPage {

    @FindBy(css= ".account_name")
    private WebElement accountName;

    @FindBy(css= "a[data-method=delete]")
    private WebElement deleteOption;

    private static final String SUBNAV_OPTION = "//a[text()='%s']";

    public String getAccountName() {
        return action.getText(accountName);
    }

    /**
     *
     * @param subnavOption Settings, Project, Account Members
     */
    public void clickSubnaveOption(String subnavOption){
        action.click(By.xpath(String.format(SUBNAV_OPTION, subnavOption)));
    }

    public void deleteAccount(){
        action.click(deleteOption);
        driver.switchTo().alert().accept();
    }

}
