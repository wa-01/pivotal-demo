package com.jalasoft.pivotal.pages.project;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectMenu extends AbstractPage {


    @FindBy(xpath = "//span[text()='more']")
    private WebElement moreButton;

    public ProjectSettingsForm clickMore(){
        //driver.navigate().refresh();
        action.click(moreButton);
        return new ProjectSettingsForm();
    }
}
