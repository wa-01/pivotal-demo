package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsAccount extends AbstractPage {
    @FindBy(xpath = "//div[@class='description']/descendant::a")
    private WebElement deletelink;

    public void clickDeleteLink() {
        action.click(deletelink);
        driver.switchTo().alert().accept();
    }
}
