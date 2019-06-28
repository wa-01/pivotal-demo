package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Class description.
 *
 * @author Jose Colina
 * @version 1.0.
 */
public class StoryForm extends AbstractPage {
    public static final String OPTION_STORY_TYPE_XPATH = "//*[@id=\"story_type_dropdown_c206\"]";
    public static final String OPTION_POINTS_XPATH = "//*[@id=\"story_estimate_dropdown_c206\"]";
    public static final String OPTION_REQUESTER_XPATH = "//*[@id=\"story_requested_by_id_dropdown_c206\"]";

    @FindBy (css = "[name=\"story[name]\"]")
    private WebElement storyTitleTextField;
    @FindBy (css = "#story_type_dropdown_c482_arrow")
    private WebElement storyTypeSelect;
    @FindBy (css = "#story_estimate_dropdown_c482_arrow")
    private WebElement pointsSelect;
    @FindBy (css = "#story_requested_by_id_dropdown_c482")
    private WebElement requesterSelect;
    @FindBy (css = ".autosaves.button.std.save")
    private WebElement saveButton;

    public void addStory(Map<String, String> data){
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("story_title", () -> action.setValue(storyTitleTextField, data.get("story_title")));
        strategyMap.put("story_type", () -> selectOption(data.get("story_type"), OPTION_STORY_TYPE_XPATH, storyTypeSelect));
        strategyMap.put("story_type", () -> selectOption(data.get("points"), OPTION_POINTS_XPATH, pointsSelect));
        strategyMap.put("story_type", () -> selectOption(data.get("requester"), OPTION_REQUESTER_XPATH, requesterSelect));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }
        action.click(saveButton);
    }

    private void selectOption(String expectedOption, String XPathOption, WebElement selectElement) {
        action.click(selectElement);
        String optionLocator = String.format(XPathOption, expectedOption);
        action.click(By.xpath(optionLocator));
    }
}
