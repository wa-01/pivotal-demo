package com.jalasoft.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Project extends AbstractPage {

    @FindBy(css = ".raw_context_name")
    private WebElement projectName;

    @FindBy(css = ".public_project_label")
    private WebElement projectPrivacy;

    @FindBy(css = "a[href*=\"/settings\"] > span")
    private WebElement moreTab;

    public String getProjectName() {
        return action.getText(projectName);
    }

    public String getProjectPrivacy() {
        return action.getText(projectPrivacy);
    }

    public ProjectSettings clickMoreTab() {
        action.click(moreTab);
        return new ProjectSettings();
    }

    public Story clickAddStory() {
        return null;
    }
}
