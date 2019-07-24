package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends AbstractPage {

    @FindBy(css = "a[href='/dashboard']")
    private WebElement dashboardIcon;

    @FindBy(css = "button[class='tc_projects_dropdown_link tc_context_name']")
    private WebElement pivotalTrackerDropdown;

    @FindBy(css = "a[href='/accounts']")
    private WebElement dropdownAccounts;

    @FindBy(css = "a[data-aid='CreateProject']")
    private WebElement dropdownCreateProject;

    @FindBy(css = "div[data-aid='menu-header']")
    private WebElement createNewProjectSelectAccount;

    public ProfileDropdown clickProfileDropdown() {
        driver.findElement(By.cssSelector("div[data-aid=\"ProfileDropdown\"] > button")).click();
        return new ProfileDropdown(driver);
    }

    public Dashboard goToDashboard() {
        action.click(dashboardIcon);
        wait.until(ExpectedConditions.titleIs("Dashboard - Pivotal Tracker"));
        return new Dashboard();
    }

    public ProfileDropdown clickPivotalTrackerDropDown() {
        action.click(pivotalTrackerDropdown);
        return new ProfileDropdown(driver);
    }

    public ProfileDropdown clickDropdownAccounts(){
        action.click(dropdownAccounts);
        return new ProfileDropdown(driver);
    }

    public ProfileDropdown clickTheCreateProjectOption(){
        action.click(dropdownCreateProject);
        return new ProfileDropdown(driver);
    }

    public ProfileDropdown checkAccountsFromCreateProject(){
        action.click(createNewProjectSelectAccount);
        return new ProfileDropdown(driver);
    }
}
