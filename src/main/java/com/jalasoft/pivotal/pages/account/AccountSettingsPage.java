package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSettingsPage extends AbstractPage {

        @FindBy (xpath = "//div[text()='%s']/ancestor::div[@class='header']/descendant::a[text()='Manage Account']")
        private WebElement manageAccount;

        @FindBy (xpath="//a[@class='button' and text()='Settings']")
        private WebElement settings;

        public SettingsPane clickSettings(){
            action.click(settings);
            return new SettingsPane();
        }
}
