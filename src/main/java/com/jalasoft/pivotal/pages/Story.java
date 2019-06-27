package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Story extends AbstractPage {


    public static final String STORY_TYPE = "a.item_%s";

    @FindBy(css = "[data-type=\"backlog\"] a[data-aid=\"AddButton\"]")
    private WebElement addStoryButtonBacklog;

    @FindBy(css = "textarea[name=\"story[name]\"]")
    private WebElement storyTitleTextArea;

    @FindBy(css = "a[id *= \"story_type_dropdown\"].arrow.target")
    private WebElement storyTypeArrow;

    @FindBy(css = "div[data-aid=\"Description\"] div[data-aid=\"renderedDescription\"]")
    private WebElement descriptionDivSection;

    @FindBy(css = "div[data-aid=\"editor\"] textarea")
    private WebElement descriptionTextArea;

    @FindBy(css = "button[data-aid=\"save\"]")
    private WebElement addDescriptionButton;

    @FindBy(css = "button[data-aid=\"cancel\"]")
    private WebElement cancelAddDescriptionButton;

    @FindBy(css = "div[data-aid=\"LabelsSearch\"] input")
    private WebElement labelsTextField;

    @FindBy(css = ".autosaves.button.std.save")
    private WebElement saveStory;

    public void clickAddStoryBacklog() {
        action.click(addStoryButtonBacklog);
    }

    public void saveStory(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("title", () -> action.setValue(storyTitleTextArea, data.get("tile")));
        strategyMap.put("story_type", () -> selectStoryType(data.get("story_type")));
        strategyMap.put("description", () -> addDescription(data.get("description"), data.get("save_description")));
        strategyMap.put("labels", () -> action.setValue(labelsTextField, data.get("labels")));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }

        action.click(saveStory);
    }

    private void selectStoryType(String story_type) {
        action.click(storyTypeArrow);
        action.click(By.cssSelector(String.format(STORY_TYPE, story_type)));
    }

    private void addDescription(String description, String save){
        action.click(descriptionDivSection);
        action.setValue(descriptionTextArea, description);
        if (save.equals("save")){
            action.click(addDescriptionButton);
        } else {
            action.click(cancelAddDescriptionButton);
        }
    }



}
