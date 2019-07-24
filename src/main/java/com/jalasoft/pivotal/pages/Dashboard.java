package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.pages.project.ProjectForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends AbstractPage {

    @FindBy(css = "#create-project-button")
    private WebElement createProjectButton;

    @FindBy(css = "a[class *= 'SettingsIcon__cog projectTileHeader__hoverable']")
    private WebElement clickProjectSettings;

    public ProjectForm clickCreateProjectButton() {
        action.click(createProjectButton);
        return new ProjectForm();
    }

    public boolean isProjectVisible(String projectName) {
        return action.isElementVisible(By.xpath(String.format("//a[@data-aid='project-name' and text() = '%s']", projectName)));
    }

    public void openProjectSettings(){
        action.click(clickProjectSettings);
    }

}
