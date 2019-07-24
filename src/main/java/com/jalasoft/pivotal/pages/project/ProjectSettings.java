package com.jalasoft.pivotal.pages.project;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSettings extends AbstractPage {

    private static final String OPTIONS_ACCOUNT_XPATH = "//option[@value='%s']";

    @FindBy(css = "#project_name")
    private WebElement projectTitleTextBox;

    @FindBy(css = "a[href*='/accounts']")
    private WebElement accountLink;

    @FindBy(css = "#project_public")
    private WebElement projectAccessCheckBox;

    @FindBy(css = "#account_change_link")
    private WebElement changeAccountLink;



    public String getProjectTitleValue() {
        return action.getAttribute(projectTitleTextBox, "value");
    }

    public String getAccountText() {
        return action.getText(accountLink);
    }

    public boolean isProjectAccessCheckBox() {

        return action.isSelected(projectAccessCheckBox);

    }


    public boolean isThisAccountInAccountSelectorOptions(String accountID) {
        action.click(changeAccountLink);
        String optionAccountLocator = String.format(OPTIONS_ACCOUNT_XPATH, accountID);
        return driver.findElements(By.xpath(optionAccountLocator)).size() > 0;
    }
}
