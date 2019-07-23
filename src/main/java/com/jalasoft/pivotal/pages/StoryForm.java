package com.jalasoft.pivotal.pages;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.jalasoft.pivotal.core.ui.ISteps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StoryForm extends AbstractPage {

    @FindBy(css = "textarea[name='story[name]']")
    private WebElement storyTitleTextArea;

    @FindBy(css = "div[class^='DescriptionShow']")
    private WebElement descriptionLabel;

    @FindBy(css = "[data-aid='textarea']")
    private WebElement descriptionTextArea;

    @FindBy(css = "[data-aid='save']")
    private WebElement saveDescriptionButton;

    @FindBy(css = "[data-aid='LabelsSearch__input']")
    private WebElement labelsTextField;

    @FindBy(css = ".autosaves.button.std.save")
    private WebElement saveStory;

    @FindBy (css = "a[id*='story_type_dropdown'].item_feature.selection")
    private WebElement storyTypeDropdownArrow;

    @FindBy (css = "a[id*='story_estimate_dropdown' ][class='arrow target']")
    private WebElement pointEstimationDropdawnArrow;

    @FindBy(xpath = "//section[@class='blockers full']//span[contains(@class, 'AddSubresourceButton__icon')]")
    private WebElement newBlockersButton;

    @FindBy(css = "textarea[id='blocker-edit-new']")
    private WebElement blockersTextArea;

    @FindBy(css = "button[data-aid='BlockerEdit__addButton']")
    private WebElement blockersAddButton;

    @FindBy(xpath = "//section[@class='tasks full']//span[contains(@class,'AddSubresourceButton__message')]")
    private WebElement tasksButton;

    @FindBy(css="textarea[aria-label='Task']")
    private WebElement taskTextArea;

    @FindBy(css = "textarea[aria-label='Comment']")
    private WebElement commentTextArea;

    @FindBy(css = "button[data-aid='comment-submit']")
    private WebElement postCommentButton;

    @FindBy(xpath = "//span[text()='<none>']")
    private WebElement ownerButton;

    @FindBy(css = "#owners_search_field")
    private WebElement ownerSearchField;


    public static final String STORY_TYPE = "li[data-value='%s']";
    public static final String POINTS_ESTIMATION = "li[data-value='%s']";

    public StoryDetail saveStory(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("title", () -> action.setValue(storyTitleTextArea, data.get("title")));
        strategyMap.put("story_type", () -> addStoryType(data.get("story_type")));
        strategyMap.put("points" , ()-> addPoints(data.get("points")));
        strategyMap.put("owner", ()-> addOwner(data.get("owner")));
        strategyMap.put("blockers", ()-> addBlocker(data.get("blockers")));
        strategyMap.put("description", () -> addDescription(data.get("description")));
        strategyMap.put("labels", () -> addLabels(data.get("labels")));
        strategyMap.put("tasks", () -> addTasks(data.get("tasks")));
        strategyMap.put("comment", () -> addComment(data.get("comment")));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }

        action.click(saveStory);

        // This needs to be removed
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new StoryDetail();
    }

    private void addStoryType(String storyType) {
        action.click(storyTypeDropdownArrow);
        action.click(By.cssSelector(String.format(STORY_TYPE, storyType)));
    }

    private void addPoints(String points) {
        action.click(pointEstimationDropdawnArrow);
        action.click(By.cssSelector(String.format(POINTS_ESTIMATION, points)));
    }

    private void addOwner(String owner){
        action.click(ownerButton);
        action.setValue(ownerSearchField, owner);
        ownerSearchField.sendKeys(Keys.RETURN);
    }

    private void addBlocker(String blockers){
        action.click(newBlockersButton);
        action.setValue(blockersTextArea, blockers);
        action.click(blockersAddButton);
    }

    private void addDescription(String description) {
        action.click(descriptionLabel);
        action.setValue(descriptionTextArea, description);
        action.click(saveDescriptionButton);
    }

    private void addLabels(String labels) {
        action.setValue(labelsTextField, labels);
        labelsTextField.sendKeys(Keys.RETURN);
    }

    private void addTasks(String taskText){
        action.click(tasksButton);
        action.setValue(taskTextArea, taskText);
        taskTextArea.sendKeys(Keys.RETURN);
    }

    private void addComment(String comment){
        action.setValue(commentTextArea, comment);
        action.click(postCommentButton);
    }
}
