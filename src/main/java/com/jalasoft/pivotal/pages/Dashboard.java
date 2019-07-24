package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.pages.project.MoreTab;
import com.jalasoft.pivotal.pages.project.ProjectDetails;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends AbstractPage {

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
        action.click(By.xpath(String.format("//a[@data-aid='project-name' and text() = '%s']", projectName)));
        new ProjectDetails().goToTab("more");
        return new MoreTab();
    }


}
