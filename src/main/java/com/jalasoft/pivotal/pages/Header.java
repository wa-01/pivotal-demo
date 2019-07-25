package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends AbstractPage {

    //@FindBy(css = "li > a[href='/dashboard']")
    @FindBy(xpath = "//img[@class='headerLogo__image']/ancestor::a")
    private WebElement dashboardIcon;

    @FindBy(css = ".tc_projects_dropdown_link")
    private WebElement pivotalTrackerDropdown;

    @FindBy(xpath = "//button[@aria-label=\"Profile Dropdown\"]")
    private WebElement profileDropdown;

    @FindBy(xpath = "//div[@data-aid='Dropdown__tabstop']/descendant::a[@href='/accounts']")
    private WebElement accountsOption;

    public ProfileDropdown clickProfileDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(profileDropdown));
        //action.click(By.xpath("//div[@data-aid='ProfileDropdown']/descendant::button[@aria-label='Profile Dropdown']"));
        driver.findElement(By.cssSelector("div[data-aid=\"ProfileDropdown\"] > button")).click();
        return new ProfileDropdown(driver);
    }

    public Dashboard goToDashboard() {
        action.click(dashboardIcon);
        wait.until(ExpectedConditions.titleContains("Pivotal Tracker"));
        return new Dashboard();
    }

    public MenuPopover clickPivotalTrackerDropDown() {
        action.click(pivotalTrackerDropdown);
        return new MenuPopover();
    }

    public void clickAccountOption() {
        //wait.until(ExpectedConditions.elementToBeClickable(profileDropdown));
        //action.click(profileDropdown);
        //driver.findElement(By.cssSelector("div[data-aid=\"ProfileDropdown\"] > button")).click();

        wait.until(ExpectedConditions.elementToBeClickable(accountsOption));
        //driver.findElement(By.xpath("//div[@data-aid='Dropdown__tabstop']/descendant::a[@href='/accounts']")).click();
        action.click(accountsOption);
    }
}
