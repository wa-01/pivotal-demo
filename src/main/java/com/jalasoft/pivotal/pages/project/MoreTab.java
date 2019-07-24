package com.jalasoft.pivotal.pages.project;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoreTab extends AbstractPage {

    private static String CSS_CHANGE_ACCOUNT_LINK ="#account_change_link";
    private static String CSS_SELECT_ACCOUNT ="#project_account_id_select";

    private static final String OPTION_ACCOUNT_XPATH = "//select[@id='project_account_id_select']/descendant::option[contains(text(),'%s (ID')]";


    public void goToSidebarOption(String option) {
        action.click(By.cssSelector(String.format("#%s", option)));
    }

    public boolean searchAccount(String accountName){
        boolean found = true;
        action.click(By.cssSelector(CSS_CHANGE_ACCOUNT_LINK));
        action.click(By.cssSelector(CSS_SELECT_ACCOUNT));
        String optionAccountLocator = String.format(OPTION_ACCOUNT_XPATH, accountName);
        found = action.isElementVisible(By.xpath(optionAccountLocator));
        return found;
    }

}
