package com.jalasoft.pivotal.pages;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectForm extends AbstractPage {


	public static final String OPTION_ACCOUNT_XPATH = "//div[@class='tc-account-selector__option-account-name' and text()='%s']";
	public static final String PRIVACY_CSS = "input[data-aid='%s']";

	@FindBy(css = "input[name=\"project_name\"]")
	private WebElement projectNameTextField;

	@FindBy(css = ".tc-account-selector__header")
	private WebElement accountSelect;

	@FindBy(css = "[data-aid=\"FormModal__submit\"]")
	private WebElement createButton;

	@FindBy(css = "a[data-aid=\"AddButton\"]")
	private WebElement addStoryLink;

	public void createProject(Map<String, String> data) {
		Map<String, ISteps> strategyMap = new HashMap<>();
		strategyMap.put("project_name", () -> action.setValue(projectNameTextField, data.get("project_name")));
		strategyMap.put("account", () -> selectAccount(data.get("account")));
		strategyMap.put("privacy", () -> action.click(By.cssSelector(String.format(PRIVACY_CSS, data.get("privacy")))));

		Set<String> keys = data.keySet();
		for (String key : keys) {
			strategyMap.get(key).execute();
		}
		action.click(createButton);
	}

	private void selectAccount(String expectedAccount) {
		action.click(accountSelect);
		String optionAccountLocator = String.format(OPTION_ACCOUNT_XPATH, expectedAccount);
		action.click(By.xpath(optionAccountLocator));
	}

	public StoryForm clickAddStoryLink() {
		action.click(addStoryLink);
		return new StoryForm();
	}
}
