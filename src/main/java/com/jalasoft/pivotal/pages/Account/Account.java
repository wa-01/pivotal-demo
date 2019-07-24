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
        TABS_BUTTONS.put("Plans & Billing", ".buttons > li > a[href*='plans']"); //.buttons > li > a[href*='settings']
        TABS_BUTTONS.put("Settings", ".buttons > li > a[href*='settings']");//ul[@class='buttons']/child::li[2]");
        TABS_BUTTONS.put("Projects", ".buttons > li > a[href*='projects']");//"//ul[@class='buttons']/child::li[3]");
        TABS_BUTTONS.put("Account Members", ".buttons > li > a[href*='memberships']");
    }

    public void clickTabMenu(String tabName){
        action.click(By.cssSelector(TABS_BUTTONS.get(tabName)));
    }

    public boolean isAccountPageLoaded(){
        return (action.isElementPresent(By.cssSelector(accountName))) &&
                action.isElementVisible(By.cssSelector(accountName));
    }
}
