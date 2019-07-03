package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.core.ui.ISteps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StoryForm extends AbstractPage {


//    a[id*='story_type_dropdown'].item_feature.selection

//    private static final String OPTION_ACCOUNT_XPATH = "//div[@class='tc-account-selector__option-account-name' and text()='%s']";
//
    private static final String STORY_TYPE = ".item_%s";

    @FindBy(css = "textarea[data-aid=\"name\"]")
    private WebElement storyNameTextField;

    @FindBy(css = "textarea[data-aid=\"textarea\"]")
    private WebElement storyDescription;


    @FindBy(css = "div[data-aid=\"renderedDescription\"]")
    private WebElement storyDescriptionEditor;

    @FindBy(css = "button[data-aid=\"save\"]")
    private WebElement buttonSave;

    @FindBy(css = "input[data-aid=\"LabelsSearch__input\"]")
    private WebElement storyLabel;

    @FindBy(css = "button[class=\"autosaves button std save\"]")
    private WebElement addStoryButton;

    @FindBy(css = "div[class=\"dropdown story_type\"]")
    private WebElement storyType;

    @FindBy(css = "span[data-aid=\"StoryPreviewItem__title\"]")
    private WebElement storyName;

    public void setStoryFields(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> action.setValue(storyNameTextField, data.get("name")));
        strategyMap.put("story_type", () -> selectStoryType(data.get("story_type")));
        strategyMap.put("description", () -> setDescription(data.get("description")));
        strategyMap.put("label", () -> addLabel(data.get("label")));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }
    }


    public void createStory( Map<String, String> data) {
        setStoryFields(data);
        action.click(addStoryButton);
//        return new ProjectDetails();
    }

    public void setDescription(String description){
        action.click(storyDescriptionEditor);
        action.setValue(storyDescription, description);
        action.click(buttonSave);

    }

    public void addLabel(String label){
        action.click(storyLabel);
        action.setValue(storyLabel, label);
        storyLabel.sendKeys(Keys.RETURN);
    }

    public void selectStoryType(String story_type){
        action.click(storyType);
        String optionAccountLocator = String.format(STORY_TYPE, story_type);
        action.click(By.cssSelector(optionAccountLocator));
    }

    public String getStoryName(){
        return action.getText(storyName);
    }

    public String getStoryType(){
        return action.getText(storyName);
    }

    public String getStoryDescription(){
        return action.getText(storyName);
    }

    public String getStoryLabel(){
        return action.getText(storyName);
    }

}
