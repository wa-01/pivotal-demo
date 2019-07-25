package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends AbstractPage {

    @FindBy(css = "a[href='/dashboard']")
    private WebElement dashboardIcon;

    @FindBy(css = ".tc_projects_dropdown_link")
    private WebElement pivotalTrackerDropdown;

    @FindBy(css = "div[data-aid=\"ProfileDropdown\"] > button")
    private WebElement profileDropdownbutton;

    public ProfileDropdown clickProfileDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(profileDropdownbutton));
        action.click(profileDropdownbutton);
        return new ProfileDropdown();
    }

    public Dashboard goToDashboard() {
        wait.until(ExpectedConditions.elementToBeClickable(dashboardIcon));
        action.click(dashboardIcon);
        wait.until(ExpectedConditions.titleIs("Dashboard - Pivotal Tracker"));
        return new Dashboard();
    }

    public MenuPopover clickPivotalTrackerDropDown() {
        action.click(pivotalTrackerDropdown);
        return new MenuPopover();
    }
}
