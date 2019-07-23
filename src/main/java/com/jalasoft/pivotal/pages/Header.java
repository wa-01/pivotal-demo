package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.pages.account.AccountPage;
import com.jalasoft.pivotal.pages.project.ProjectSettingsForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends AbstractPage {

    @FindBy(css = "a[href='/dashboard']")
    private WebElement dashboardIcon;

    @FindBy(css = ".tc_projects_dropdown_link")
    private WebElement pivotalTrackerDropdown;

    @FindBy(xpath = "//a[@href='/reports']/preceding-sibling::a[@href='/accounts']")
    private WebElement accounts;

    @FindBy (css = "div[data-aid=\"ProfileDropdown\"] > button")
    private WebElement profileDropdownButton;

    public ProfileDropdown clickProfileDropdown() {
        action.click(profileDropdownButton);
        return new ProfileDropdown(driver);
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

    public AccountPage clickAccounts(){
        action.click(accounts);
        return new AccountPage();
    }

}
