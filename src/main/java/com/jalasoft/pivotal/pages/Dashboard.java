package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.pages.project.ProjectForm;
import com.jalasoft.pivotal.pages.project.ProjectSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends AbstractPage {

    private static final String PROJECT_SETTINGS_XPATH = "//a[@data-aid='project-name' and contains(text() , '%s')]//ancestor::div[@class='projectTileHeader__titleRow']//span[@data-balloon='Project settings']";

    @FindBy(css = "#create-project-button")
    private WebElement createProjectButton;

    public ProjectForm clickCreateProjectButton() {
        action.click(createProjectButton);
        return new ProjectForm();
    }

    public boolean isProjectVisible(String projectName) {
        return action.isElementVisible(By.xpath(String.format("//a[@data-aid='project-name' and text() = '%s']", projectName)));
    }

    public ProjectSettings clickProjectSettings(String projectName){
        String projectNameSettingsLocator = String.format(PROJECT_SETTINGS_XPATH, projectName);
        action.click(By.xpath(projectNameSettingsLocator));
        return new ProjectSettings();
    }
}
