package com.jalasoft.pivotal.pages;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class StoryForm extends AbstractPage{

    public static final String STORY_TYPE_XPATH = "//span[@class='dropdown_label' and text()='%s']";
    public static final String STORY_OWNER_XPATH = "//span[@class='name' and text()='%s']";

    @FindBy(css = "textarea[name=\"story[name]\"]")
    private WebElement storyNameTextField;

    @FindBy(css = ".selection.item_feature")
    private WebElement storyTypeDropdown;

    @FindBy(css = ".selectable_owner_row_element.add_owner.selected")
    private WebElement storyOwner;

    @FindBy(css = "[data-aid=\"renderedDescription\"]")
    private WebElement descriptionShow;

    @FindBy(css = "textarea[data-aid=\"textarea\"]")
    private WebElement descriptionEdit;

    @FindBy(css = "[data-aid=\"save\"]")
    private WebElement saveDescription;
/*
    @FindBy(css = "input[data-aid=\"LabelsSearch__input\"]")
    private WebElement labelsSearch;
*/
    @FindBy(css = "[data-aid=\"BlockerAdd\"]")
    private WebElement blockerAddButton;

    @FindBy(css = "#blocker-edit-new")
    private WebElement blockerEditView;

    @FindBy(css = "[data-aid=\"BlockerEdit__addButton\"]")
    private WebElement blockerEditAddButton;

    @FindBy(css = "[data-aid=\"TaskAdd\"]")
    private WebElement taskAdd;

    @FindBy(css = "[data-aid=\"new\"]")
    private WebElement taskEditNew;

    @FindBy(css = "[data-aid=\"addTaskButton\"]")
    private WebElement addTaskButton;

    @FindBy(css = ".autosaves.button.std.save")
    private WebElement storyClose;

    @FindBy(css = "[data-aid=\"Comment__textarea\"]")
    private WebElement commentTextArea;

    @FindBy(css = "[data-aid=\"comment-submit\"]")
    private WebElement commentSubmit;

    public void createStory(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();

        strategyMap.put("story_name", () -> action.setValue(storyNameTextField, data.get("story_name")));
        strategyMap.put("description_edit", () -> setDescription(data.get("description_edit")));
        strategyMap.put("blocker_edit", () -> setBlocker(data.get("blocker_edit")));
        strategyMap.put("add_task", () -> addTask(data.get("add_task")));
        strategyMap.put("story_type", () -> setType(data.get("story_type")));
        strategyMap.put("story_owner", () -> setOwner(data.get("story_owner")));
    //    strategyMap.put("label_search", () -> setLabel(data.get("label_search")));
        strategyMap.put("comment_text_area", () -> action.setValue(commentTextArea, data.get("comment_text_area")));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }

        action.click(storyClose);
    }

    public CurrentBacklog getCurrentBacklog() {
        //driver.findElement(By.cssSelector("div[data-aid=\"ProfileDropdown\"] > button")).click();
        return new CurrentBacklog(driver);
    }

    private void setDescription(String description) {
        action.click(descriptionShow);
        action.setValue(descriptionEdit, description);
        action.click(saveDescription);
    }

    private void setBlocker(String blocker) {
        action.click(blockerAddButton);
        action.setValue(blockerEditView, blocker);
        action.click(blockerEditAddButton);
    }

    private void addTask(String task) {
        action.click(taskAdd);
        action.setValue(taskEditNew, task);
        action.click(addTaskButton);
    }

    private void setType(String expectedType) {
        action.click(storyTypeDropdown);
        String optionstoryTypeLocator = String.format(STORY_TYPE_XPATH, expectedType);
        action.click(By.xpath(optionstoryTypeLocator));
    }

    private void setOwner(String expectedOwner) {
        action.click(storyOwner);
        String storyOwnerLocator = String.format(STORY_OWNER_XPATH, expectedOwner);
        action.click(By.xpath(storyOwnerLocator));
    }
/*
    private void setLabel(String label) {
        action.setValue(labelsSearch, label);
    }*/

}
