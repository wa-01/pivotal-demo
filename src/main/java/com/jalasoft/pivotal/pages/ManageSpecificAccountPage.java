package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.pages.project.ProjectForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageSpecificAccountPage extends AccountPage {

    private static final String MANAGE_ACCOUNT_TAB_XPATH = "//ul[@class='buttons']//a[text()='%s']";

    /*Element of Settings Tab */
    @FindBy(css = "a[data-method='delete']")
    private WebElement deleteAccountLink;

    @FindBy(xpath = "//h4[text()='ID']/following-sibling::div")
    private WebElement accountID;

    /*Element of Projects Tab */
    @FindBy(css = "#new_project_link")
    private WebElement newProjectLink;

    //private ProjectForm projectForm;

    /*
    @FindBy(xpath = "//input[@name='project_name']")
    private WebElement inputProjectName;

    @FindBy(xpath = "//button[@data-aid='FormModal__submit']")
    private WebElement createProjectButton;
*/

    public void selectManageAccountTab(String option) {
        String tabToSelect = String.format(MANAGE_ACCOUNT_TAB_XPATH,option);
        action.click(By.xpath(tabToSelect));
        //return accountID.getText();
    }

    public AccountPage deleteAccount(){
        action.click(deleteAccountLink);
        action.confirmDialog();
        return new AccountPage();
    }

    public String getAccountID() {
        selectManageAccountTab("Settings");
        return accountID.getText();
    }

    public ProjectForm clickOnCreateProjectLink() {
        action.click(newProjectLink);
        return new ProjectForm();

    }
}
