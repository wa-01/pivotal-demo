package com.jalasoft.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSettings extends AbstractPage {

    @FindBy(css = "#project_name")
    private WebElement projectTitle;

    @FindBy(css = "a[href*='/accounts']")
    private WebElement projectAccount;

    @FindBy(css = "a#delete_link")
    private WebElement deleteLink;

    public String getProjectTitle(){
        return action.getFieldValue(projectTitle);
    }

    public String getAccount(){
        return action.getText(projectAccount);
    }

    public void deleteProject(){
        action.click(deleteLink);
    }
}
