package com.jalasoft.pivotal.pages.project;

import com.jalasoft.pivotal.pages.AbstractPage;
import com.jalasoft.pivotal.pages.StoryForm;
import org.openqa.selenium.By;

public class StoriesTab extends AbstractPage {

    private static final String BACKLOG_A_DATA_AID_ADD_BUTTON = ".%s a[data-aid=\"AddButton\"]";

    public StoryForm clickAddStoryButton(String panelName) {
        action.click(By.cssSelector(String.format(BACKLOG_A_DATA_AID_ADD_BUTTON, panelName)));
        return new StoryForm();
    }
}
