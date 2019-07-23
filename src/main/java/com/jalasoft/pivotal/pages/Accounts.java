package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.core.ui.ISteps;
import com.jalasoft.pivotal.pages.project.ProjectDetails;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Accounts extends AbstractPage{

    private Header header;

    @FindBy(css = ".create_account_button")
    private WebElement createAccountButton;

    @FindBy(css = "input[data-aid='input']")
    private WebElement accountNameTextInput;

    @FindBy(css = "button[type='submit']")
    private WebElement accountCreateButton;

    @FindBy(css = "a[href='/accounts']")
    private WebElement accountsTab;

    @FindBy(xpath = "//a[contains(text(),'Settings')]")
    private WebElement settingsTab;

    @FindBy(css = ".project_name")
    private WebElement selectProject;

    @FindBy(xpath = "//a[@data-aid='navTab-more']//child::span")
    private WebElement moreTab;

    @FindBy(xpath = "//a[contains(text(),'delete this account')]")
    private WebElement deleteAccount;

    @FindBy(css = "a[id='account_change_link']")
    private WebElement changeAccountButton;

    @FindBy(css = "select[id='project_account_id_select']")
    private WebElement selectAccountsDropdown;

    @FindBy(css = "a[id='cancel_button_id']")
    private WebElement clickCancelButton;

    public void clickCreateAccount(){
        action.click(createAccountButton);
    }

    public void setAccountName(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("accountName", () -> action.setValue(accountNameTextInput, data.get("accountName")));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }

        action.click(accountCreateButton);
    }

    public void clickAccountsTab(){
        wait.until(ExpectedConditions.titleIs("Account Plans - Pivotal Tracker"));
        action.click(accountsTab);
    }

    public void clickManageAccountButton(String accountName) {
        action.click(By.xpath(String.format("//div[contains(text(),'%s')]//ancestor::div[@class='header']//descendant::a[contains(text(),'Manage Account')]", accountName)));
    }

    public void clickSettingsTab(){
        action.click(settingsTab);
    }

    public void clickDeleteAccount(){
        action.click(deleteAccount);
    }

    public void acceptDeleteAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean checkAccountNameAvailability(String accountName){
        return action.isElementVisible(By.xpath(String.format("//div[contains(text(),'%s')]", accountName)));
    }

    public String getDeletedMessage(){
        return action.getText(By.xpath(String.format("//li[contains(text(),'was successfully deleted.')]")));
    }

    public void getProjectSettingsAccounts(){
        action.click(selectProject);
        action.click(moreTab);
        action.click(changeAccountButton);
        action.click(selectAccountsDropdown);
        selectAccountsDropdown.sendKeys(Keys.ESCAPE);
        action.click(clickCancelButton);
    }

    public boolean checkAccountInProjectSetting(String accountName){
        return action.isElementVisible(By.xpath(String.format("//option[contains(text(),'%s')]", accountName)));
    }

}
