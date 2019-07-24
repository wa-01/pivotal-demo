package com.jalasoft.pivotal.pages.accounts;/*
 * @autor: mauricioramirez
 * Project: pivotal-demo
 * Package: com.jalasoft.pivotal.pages
 * Version: 1.0
 */

import com.jalasoft.pivotal.core.ui.ISteps;
import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NewAccountForm extends AbstractPage {

    @FindBy(css = "label[for=\"account_name\"] + input")
    private WebElement accountNameTextField;

    @FindBy(css = ".tc-form-modal-footer > button[data-aid=\"FormModal__submit\"]")
    private WebElement submitButton;

    @FindBy(css = ".tc-form-modal-footer > button[data-aid=\"FormModal__cancel\"]")
    private WebElement cancelButton;

    public void setFormfields(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("account_name", () -> action.setValue(accountNameTextField, data.get("account_name")));

        Set<String> keys = data.keySet();
        for (String key: keys) {
            strategyMap.get(key).execute();
        }
    }

    public ManageAccountPage clickSubmitButton() {
        action.click(submitButton);

        driver.navigate().refresh();
        return new ManageAccountPage();
    }

    public AccountsPage clickCancelButton() {
        action.click(cancelButton);

        return new AccountsPage();
    }

}
