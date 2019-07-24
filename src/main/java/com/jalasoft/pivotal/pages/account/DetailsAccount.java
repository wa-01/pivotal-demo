package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsAccount extends AbstractPage {
    private static String CSS_DETAILS_TITLE = ".account_name";

    private static String XPATH_SETTINGS_TAB ="//ul[@class='buttons']/descendant::a[text()='Settings']";

    @FindBy(xpath = "//div[text()='%s']/ancestor::div[@class='header']/descendant::a[contains(@id,'manage_account')]")
    WebElement accountRow;

    public String getAccountName() {
        return action.getText(By.cssSelector(CSS_DETAILS_TITLE));
    }

    public SettingsAccount clickSettingtab() {
        action.click(By.xpath(XPATH_SETTINGS_TAB));
        return new SettingsAccount();
    }
}
