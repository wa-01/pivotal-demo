package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import com.jalasoft.pivotal.pages.project.ProjectMenu;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPane extends AbstractPage {

    @FindBy (xpath = "//a[text()='delete this account']")
    private WebElement deleteAccount;

    @FindBy (css = ".header_button")
    private WebElement createProject;

    @FindBy (css = ".project_name")
    private WebElement anyProjectLink;

    public AccountSettingsPage deleteAccount(){
        action.click(deleteAccount);
        driver.switchTo().alert().accept();
        return new AccountSettingsPage();
    }

    public ProjectForm createProject(){
        action.click(createProject);
        return new ProjectForm();
    }

    public ProjectMenu openAnyProject(){
        action.click(anyProjectLink);
     //   driver.navigate().refresh();
        return new ProjectMenu();
    }
}

