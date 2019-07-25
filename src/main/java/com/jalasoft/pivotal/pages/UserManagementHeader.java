package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserManagementHeader extends AbstractPage{

    private static final String SECTIONS_MENU = "//a[text()=\"%s\"]";

    @FindBy(css = "textarea[name='story[name]']")
    private WebElement storyTitleTextArea;

    public AccountsPanel clickAccountOption(){
        action.click(By.xpath(String.format(SECTIONS_MENU, "accounts")));
        return new AccountsPanel();
    }

    public Profile clickProfileOption(){
        action.click(By.xpath(String.format(SECTIONS_MENU, "profile")));
        return new Profile();
    }

    public NotificationSettings clickNotificationSettings(){
        action.click(By.xpath(String.format(SECTIONS_MENU, "notifications settings" )));
        return new NotificationSettings();
    }

}
