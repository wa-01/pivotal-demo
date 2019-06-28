package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Story extends AbstractPage {


    private static final String STORY_TYPE = "a.item_%s";
    private static final String STORY_MODEL_NAME = "div[aria-label=\"%s\"] .story_name";

    @FindBy(css = "[data-type=\"backlog\"] a[data-aid=\"AddButton\"]")
    private WebElement addStoryButtonBacklog;

    @FindBy(css = "[name=\"story[name]\"]")
    private WebElement storyTitleTextArea;

    @FindBy(css = "a[id *= \"story_type_dropdown\"].arrow.target")
    private WebElement storyTypeArrow;

    @FindBy(css = "[class^=\"DescriptionShow\"]")
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
        strategyMap.put("title", () -> action.setValue(storyTitleTextArea, data.get("title")));
        strategyMap.put("story_type", () -> selectStoryType(data.get("story_type")));
        strategyMap.put("description", () -> addDescription(data.get("description")));
        strategyMap.put("labels", () -> addLabels(data.get("labels")));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }

        action.click(saveStory);
    }

    private void addLabels(String labels) {
        action.setValue(labelsTextField, labels);
        labelsTextField.sendKeys(Keys.RETURN);
    }

    private void selectStoryType(String story_type) {
        action.click(storyTypeArrow);
        action.click(By.cssSelector(String.format(STORY_TYPE, story_type)));
    }

    private void addDescription(String description) {
        action.click(descriptionDivSection);
        action.setValue(descriptionTextArea, description);
        action.click(addDescriptionButton);
    }

    public String getStoryModelName(String title) {
        return action.getText(By.cssSelector(String.format(STORY_MODEL_NAME, title)));
    }

}
