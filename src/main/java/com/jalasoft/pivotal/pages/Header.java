package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractPage {

    @FindBy(css = "div[data-aid=\"ProfileDropdown\"] > button")
    private WebElement profileButton;

    @FindBy(css = ".tc_projects_dropdown_link .tc_context_name")
    private WebElement logoButton;

    @FindBy(css = ".tc_projects_dropdown_link.tc_context_name span.raw_context_name public")
    private WebElement projectName;

    public ProfileDropdown clickProfileDropdown() {
        action.click(profileButton);
        return new ProfileDropdown(driver);
    }

    public String getLogoButtonText() {
        return action.getText(projectName);
    }

    public ProjectsWorkspacesDropdown clickProjectsWorkspacesDropdown() {
        action.click(logoButton);
        return new ProjectsWorkspacesDropdown();
    }
}
