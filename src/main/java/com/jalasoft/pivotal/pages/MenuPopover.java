package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPopover extends AbstractPage {

    @FindBy(css = ".tc_projects_menu_show_all")
    private WebElement showAllProjectsLink;



    public boolean isProjectVisible(String projectName) {
        return action.isElementVisible(By.xpath(String.format("//span[contains(@class, 'raw_project_name') and text() = '%s']", projectName)));
    }

    public String getPrivacyByProject(String projectName) {
        return action.getText(By.xpath(String.format("//span[contains(@class, 'raw_project_name') and text() = '%s']/following-sibling::span", projectName))).toLowerCase().trim();
    }

    public ShowAll clickShowAllProjectsLink() {
        action.click(showAllProjectsLink);
        return new ShowAll();
    }
}
