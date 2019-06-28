package com.jalasoft.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class description.
 *
 * @author Jose Colina
 * @version 1.0.
 */
public class DashboardProject extends AbstractPage{

    @FindBy(xpath = "//*[@id='panel_backlog_2359630']/div/header/div/div[3]/div[1]/a")
    private WebElement addStoryButton;

    public StoryForm clickAddStoryButton() {
        action.click(addStoryButton);
        return new StoryForm();
    }
}
