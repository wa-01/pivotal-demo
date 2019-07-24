package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.pages.project.ProjectForm;
import com.jalasoft.pivotal.pages.project.ProjectSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends AbstractPage {

    private static final String X_PROJECT_SETTINGS_LINK = "//a[text()='%s']/../following-sibling::div/span[@data-balloon='Project settings']";


    @FindBy(css = "#create-project-button")
    private WebElement createProjectButton;

    public ProjectForm clickCreateProjectButton() {
        action.click(createProjectButton);
        return new ProjectForm();
    }

    public boolean isProjectVisible(String projectName) {
        return action.isElementVisible(By.xpath(String.format("//a[@data-aid='project-name' and text() = '%s']", projectName)));
    }

    public ProjectSettings goToSpecificProjectSettings(String projectName) {

        String optionAccountLocator = String.format(X_PROJECT_SETTINGS_LINK, projectName);
        action.click(By.xpath(optionAccountLocator));
        return new ProjectSettings();
    }

}
