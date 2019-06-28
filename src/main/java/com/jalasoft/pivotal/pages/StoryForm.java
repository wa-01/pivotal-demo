
package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StoryForm extends AbstractPage {

    @FindBy(css = "textarea[data-aid=\"name\"]")
    private WebElement storyNameTextField;

    @FindBy(css = "button[class=\"autosaves button std save\"]")
    private WebElement saveButton;

    @FindBy(css = "span[data-aid=\"StoryPreviewItem__title\"]")
    private WebElement storyNameGet;

    public void createStory(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("story_name", () -> action.setValue(storyNameTextField, data.get("story_name")));
        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }
        action.click(saveButton);
    }
    public String gettextStoryName() {
        return action.getText(storyNameGet);
//        String textStoryName = driver.findElement(By.cssSelector("span[data-aid=\"StoryPreviewItem__title\"]")).getText();

//        action.click(By.xpath(optionAccountLocator));
//        return textStoryName;
    }
}
