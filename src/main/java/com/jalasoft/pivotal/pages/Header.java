package com.jalasoft.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends AbstractPage {

    @FindBy(css = "a[href='/dashboard']")
    private WebElement dashboardIcon;

    @FindBy(css = ".tc_projects_dropdown_link")
    private WebElement pivotalTrackerDropdown;

    @FindBy(css = "div[data-aid=\"ProfileDropdown\"] > button")
    private WebElement profileDropdownButton;

    public ProfileDropdown clickProfileDropdown() {
        action.click(profileDropdownButton);
        return new ProfileDropdown();
    }

    public Dashboard goToDashboard() {
        action.click(dashboardIcon);
        wait.until(ExpectedConditions.titleIs("Dashboard - Pivotal Tracker"));
        return new Dashboard();
    }

    public MenuPopover clickPivotalTrackerDropDown() {
        action.click(pivotalTrackerDropdown);
        return new MenuPopover();
    }
}
