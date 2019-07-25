package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.pages.project.MoreTab;
import com.jalasoft.pivotal.pages.project.ProjectDetails;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Dashboard extends AbstractPage {

    private static String XPATH_PROJECT_NAME = "//a[@data-aid='project-name' and text() = '%s']";

    @FindBy(css = "#create-project-button")
    private WebElement createProjectButton;

    public ProjectForm clickCreateProjectButton() {
        action.click(createProjectButton);
        return new ProjectForm();
    }

    public boolean isProjectVisible(String projectName) {
        return action.isElementVisible(By.xpath(String.format("//a[@data-aid='project-name' and text() = '%s']", projectName)));
    }

    public ProjectForm clickCreateProjectButton(String name) {
        action.click(createProjectButton);
        return new ProjectForm();
    }

    public MoreTab clickProject(String projectName){
        String projName = String.format(XPATH_PROJECT_NAME, projectName);
        action.click(By.xpath(projName));
        new ProjectDetails().goToTab("more");
        return new MoreTab();
    }


}
