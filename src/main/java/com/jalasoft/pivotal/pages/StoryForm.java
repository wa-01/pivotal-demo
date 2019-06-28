package com.jalasoft.pivotal.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StoryForm extends AbstractPage {

    @FindBy(css = "[aria-label=\"story title\"]")
    private WebElement storyTitleTextArea;

    @FindBy(css = "[class^=\"DescriptionShow\"]")
    private WebElement descriptionClick;

    @FindBy(css = "[data-aid=\"textarea\"]")
    private WebElement descriptionTextArea;

    @FindBy(css = "[data-aid=\"save\"]")
    private WebElement saveDescriptionButton;


    @FindBy(css = "[data-aid=\"LabelsSearch__input\"]")
    private WebElement labelsTextField;

    @FindBy(css = ".autosaves.button.std.save")
    private WebElement saveStory;


    public void saveStory(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("title", () -> action.setValue(storyTitleTextArea, data.get("title")));
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

    private void addDescription(String description) {
        action.click(descriptionClick);
        action.setValue(descriptionTextArea, description);
        action.click(saveDescriptionButton);
    }

}


