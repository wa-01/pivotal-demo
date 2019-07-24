package com.jalasoft.pivotal.pages.project;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class ProjectDetails extends AbstractPage {
    //Added for WEB-AUT evaluation jose colina
    private Map<String, String> TAB_BUTTONS;

    @FindBy(css = ".raw_context_name")
    private WebElement projectNameLabel;

    @FindBy(css = ".public_project_label")
    private WebElement projectPrivacyLabel;

    private String sidebarButton = "[class*='Sidebar__toggleContainer']";

    public ProjectDetails(){
        TAB_BUTTONS = new HashMap<>();
        TAB_BUTTONS.put("STORIES", "a[data-aid='navTab-stories']");
        TAB_BUTTONS.put("ANALITYCS", "a[data-aid='navTab-analytics']");
        TAB_BUTTONS.put("MEMBERS", "a[data-aid='navTab-members']");
        TAB_BUTTONS.put("MORE", "a[data-aid='navTab-more']");
    }

    public String getProjectNameLabel() {
        return action.getText(projectNameLabel);
    }

    public String getProjectPrivacyLabel() {
        return action.getText(projectPrivacyLabel).toLowerCase();
    }

    //Added for WEB-AUT evaluation jose colina
    public MorePage goToTab(String tab) {
        action.click(By.cssSelector(TAB_BUTTONS.get(tab)));
        return new MorePage();
    }

    public boolean isProjectPageLoaded(){
        return (action.isElementPresent(By.cssSelector(sidebarButton))) &&
                action.isElementVisible(By.cssSelector(sidebarButton));
    }

}
