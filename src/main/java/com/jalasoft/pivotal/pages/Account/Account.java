package com.jalasoft.pivotal.pages.Account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class Account extends AbstractPage {
    private Map<String, String> TABS_BUTTONS;
    private String accountName = ".account_name";

    public Account(){
        TABS_BUTTONS = new HashMap<>();
        TABS_BUTTONS.put("Plans & Billing", "//ul[@class='buttons']/child::li[1]");
        TABS_BUTTONS.put("Settings", "//ul[@class='buttons']/child::li[2]");
        TABS_BUTTONS.put("Projects", "//ul[@class='buttons']/child::li[3]");
        TABS_BUTTONS.put("Account Members", "//ul[@class='buttons']/child::li[4]");
    }

    public void clickTabMenu(String tabName){
        action.click(By.xpath(TABS_BUTTONS.get(tabName)));
    }

    public boolean isAccountPageLoaded(){
        return (action.isElementPresent(By.cssSelector(accountName))) &&
                action.isElementVisible(By.cssSelector(accountName));
    }
}
