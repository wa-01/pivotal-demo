package com.jalasoft.pivotal.pages.project;

import com.jalasoft.pivotal.core.ui.ISteps;
import com.jalasoft.pivotal.pages.AbstractPage;
import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProjectForm extends AbstractPage {

    private static final String OPTION_ACCOUNT_XPATH = "//div[@class='tc-account-selector__option-account-name' and text()='%s']";

    private static final String PRIVACY_CSS = "input[data-aid='%s']";

    public static final String OPTION_NEW_ACCOUNT_CSS = "span.tc-account-selector__create-account-text";


    @FindBy(css = "input[name=\"project_name\"]")
    private WebElement projectNameTextField;

    @FindBy(css = ".tc-account-selector__header")
    private WebElement accountSelect;

    @FindBy(css = "[data-aid=\"FormModal__submit\"]")
    private WebElement createButton;

    @FindBy(css = "[data-aid=\"FormModal__cancel\"]")
    private WebElement cancelButton;

    @FindBy(xpath = "//div[@data-aid=\"new-account-name\"]/descendant::input")
    private WebElement newAccountName;

    @FindBy(xpath = "//img[@class='headerLogo__image']/ancestor::a")
    private WebElement dashboardIcon;

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

    public boolean searchAccount(String expectedAccount) {
        boolean found = true;
        action.click(accountSelect);
        String optionAccountLocator = String.format(OPTION_ACCOUNT_XPATH, expectedAccount);
        found = action.isElementVisible(By.xpath(optionAccountLocator));
        action.click(cancelButton);
        return found;
    }


    public void setProjectFieldsNewAccount(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> action.setValue(projectNameTextField, data.get("name")));
        strategyMap.put("account", () -> addNewAccount(data.get("account") + System.currentTimeMillis()));
        strategyMap.put("privacy", () -> action.click(By.cssSelector(String.format(PRIVACY_CSS, data.get("privacy")))));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }
    }

    public ProjectDetails createProjectWithNewAccount (Map<String, String> data){
        setProjectFieldsNewAccount(data);
        action.click(createButton);
        return new ProjectDetails();
    }

    private void addNewAccount (String newAccount){
        action.click(accountSelect);
        action.click(By.cssSelector(OPTION_NEW_ACCOUNT_CSS));
        action.setValue(newAccountName, newAccount);
    }
}
