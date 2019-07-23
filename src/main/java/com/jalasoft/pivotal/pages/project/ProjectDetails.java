package com.jalasoft.pivotal.pages.project;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectDetails extends AbstractPage {
    //Added for WEB-AUT evaluation jose colina
    @FindBy (css ="a[data-aid='navTab-more']")
    WebElement moreButton;

    @FindBy(css = ".raw_context_name")
    private WebElement projectNameLabel;

    @FindBy(css = ".public_project_label")
    private WebElement projectPrivacyLabel;

    public void goToTab(String tab) {
        action.click(By.cssSelector(String.format("a[data-aid='navTab-%s']", tab)));
    }

    public String getProjectNameLabel() {
        return action.getText(projectNameLabel);
    }

    public String getProjectPrivacyLabel() {
        return action.getText(projectPrivacyLabel).toLowerCase();
    }

    //Added for WEB-AUT evaluation jose colina
    public MorePage clickMoreMenu(){
        action.click(moreButton);
        return new MorePage();
    }

}
