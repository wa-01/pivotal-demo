package com.jalasoft.pivotal.pages.project;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.jalasoft.pivotal.pages.AbstractPage;
import com.jalasoft.pivotal.core.ui.ISteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectForm extends AbstractPage {

    private static final String OPTION_ACCOUNT_XPATH = "//div[@class='tc-account-selector__option-account-name' and text()='%s']";

    private static final String PRIVACY_CSS = "input[data-aid='%s']";

    @FindBy(css = "input[name=\"project_name\"]")
    private WebElement projectNameTextField;

    @FindBy(css = ".tc-account-selector__header")
    private WebElement accountSelect;

    @FindBy(css = "[data-aid=\"FormModal__submit\"]")
    private WebElement createButton;

    @FindBy(css = "button[class *='Button--open']")
    private WebElement cancelButton;

    public void setProjectFields(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> action.setValue(projectNameTextField, data.get("name") + System.currentTimeMillis()));
        strategyMap.put("account", () -> selectAccount(data.get("account")));
        strategyMap.put("privacy", () -> action.click(By.cssSelector(String.format(PRIVACY_CSS, data.get("privacy")))));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }
    }

    public ProjectDetails createProject(Map<String, String> data) {
        setProjectFields(data);
        action.click(createButton);
        return new ProjectDetails();
    }

    private void selectAccount(String expectedAccount) {
        action.click(accountSelect);
        String optionAccountLocator = String.format(OPTION_ACCOUNT_XPATH, expectedAccount);
        action.click(By.xpath(optionAccountLocator));
    }

    public boolean isAccountVisible(String accountName) {
        action.click(accountSelect);
        return action.isElementVisible(By.xpath(String.format(OPTION_ACCOUNT_XPATH, accountName)));
    }

    public void cancel() {
        action.click(cancelButton);
    }

}
