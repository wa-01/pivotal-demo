package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageAccount extends AbstractPage {

    // Static variables used to select a tab
    public final static String PLAN_BILLING = "Plans & Billing";
    public final static String SETTINGS = "Settings";
    public final static String Projects = "Projects";
    public final static String ACCOUNT_MEMBERS = "Account Members";

    // String locator used to select a tab in the Account details page
    private final String ACCOUNT_TAB = "//ul[@class='buttons']/descendant::a[text()='%s']";

    @FindBy(css = ".account_name span")
    private WebElement accountName;

    public String getAccountName(){
        return action.getText(accountName);
    }

    public void clickOnTab(String tabName){
        // Method to click the tabs: "Plans & Billing", "Settings", "Projects", "Account Members"
        action.click(By.xpath(String.format(ACCOUNT_TAB, tabName)));
    }

}
