package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageSpecificAccountPage extends AccountPage {

    private static final String MANAGE_ACCOUNT_TAB_XPATH = "//ul[@class='buttons']//a[text()='%s']";

    @FindBy(css = "a[data-method='delete']")
    private WebElement deleteAccountLink;

    @FindBy(xpath = "//h4[text()='ID']/following-sibling::div")
    private WebElement accountID;



    public String selectSettingsTab(String option) {
        String tabToSelect = String.format(MANAGE_ACCOUNT_TAB_XPATH,option);
        action.click(By.xpath(tabToSelect));
        return accountID.getText();
    }

    public AccountPage deleteAccount(){
        action.click(deleteAccountLink);
        action.confirmDialog();
        return new AccountPage();
    }

}
