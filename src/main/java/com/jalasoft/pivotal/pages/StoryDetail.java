package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;

public class StoryDetail extends AbstractPage {

    private static final String STORY_MODEL_NAME = "div[aria-label=\"%s\"] .story_name";

    public String getStoryModelName(String title) {
        return action.getText(By.cssSelector(String.format(STORY_MODEL_NAME, title)));
    }
}


