package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractPage {

    @FindBy(css = "a[href='/dashboard']")
    private WebElement dashboardIcon;

    @FindBy(css = ".tc_projects_dropdown_link")
    private WebElement pivotalTrackerDropdown;

    public ProfileDropdown clickProfileDropdown() {
        driver.findElement(By.cssSelector("div[data-aid=\"ProfileDropdown\"] > button")).click();
        return new ProfileDropdown(driver);
    }

    public Dashboard goToDashboard() {
        action.click(dashboardIcon);
        return new Dashboard();
    }

    public MenuPopover clickPivotalTrackerDropDown() {
        action.click(pivotalTrackerDropdown);
        return new MenuPopover();
    }
}
