package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.pages.project.ProjectForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends AbstractPage {
    //Added for WEB-AUT evaluation jose colina
    private String PROJECT_TITLE = "//a[contains(@class,'projectTileHeader') and text() = '%s']";

    @FindBy(css = "#create-project-button")
    private WebElement createProjectButton;

    public ProjectForm clickCreateProjectButton() {
        action.click(createProjectButton);
        return new ProjectForm();
    }

    public boolean isProjectVisible(String projectName) {
        return action.isElementVisible(By.xpath(String.format("//a[@data-aid='project-name' and text() = '%s']", projectName)));
    }

    //Added for WEB-AUT evaluation jose colina
    public void clickProjectLink(String projectName){
        action.click(By.xpath(String.format(PROJECT_TITLE, projectName)));
    }
}
