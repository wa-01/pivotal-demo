package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProjectPanel extends AbstractPage {





        @FindBy(css = "[data-type=\"backlog\"] a[data-aid=\"AddButton\"]")
        private WebElement addStoryButtonBacklog;



        public StoryForm clickAddStoryBacklog() {
            action.click(addStoryButtonBacklog);
            return new StoryForm();
        }




}
