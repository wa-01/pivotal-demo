package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.pages.project.ProjectForm;
import com.jalasoft.pivotal.pages.project.ProjectSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends AbstractPage {

    @FindBy(css = "#create-project-button")
    private WebElement createProjectButton;

    @FindBy(css = "#projects-search-bar")
    private WebElement projectSearchText;

    private static final String PROJECT_SETTING_BUTTON = "//a[contains(text(),'%s')]/parent::div//following-sibling::div/span[@data-balloon='Project settings']";

    public ProjectForm clickCreateProjectButton() {
        action.click(createProjectButton);
        return new ProjectForm();
    }

    public boolean isProjectVisible(String projectName) {
        return action.isElementVisible(By.xpath(String.format("//a[@data-aid='project-name' and text() = '%s']", projectName)));
    }

    public void searchProjectWithName(String projectName){
        action.setValue(projectSearchText, projectName);
    }

    public ProjectSettings clickProjectSettingsButton(String projectName){
        action.click(By.xpath(String.format(PROJECT_SETTING_BUTTON, projectName)));
        return new ProjectSettings();
    }


}
