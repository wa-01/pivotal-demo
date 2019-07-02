package com.jalasoft.pivotal.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPanel extends AbstractPage {


    @FindBy(css = "[data-type=\"backlog\"] a[data-aid=\"AddButton\"]")
    private WebElement addStoryButtonBacklog;


    public StoryForm clickAddStoryBacklog() {
        action.click(addStoryButtonBacklog);
        return new StoryForm();
    }

}
