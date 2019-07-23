package com.jalasoft.pivotal.pages.project;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSettings extends AbstractPage {

    @FindBy(css = "#project_name")
    private WebElement projectTitleTextBox;

    @FindBy(css = "a[href*='/accounts']")
    private WebElement accountLink;

    @FindBy(css = "#project_public")
    private WebElement projectAccessCheckBox;

    @FindBy(css = "#account_change_link")
    private WebElement changeAccountLink;

    @FindBy(css = "select[id=project_account_id_select]")
    private WebElement changeAccountSelect;

    public String getProjectTitleValue() {
        return action.getAttribute(projectTitleTextBox, "value");
    }

    public String getAccountText() {
        return action.getText(accountLink);
    }

    public boolean isProjectAccessCheckBox() {
        return action.isSelected(projectAccessCheckBox);
    }

    public boolean isAccountInChangeAccountSelector(String accountName) {
        action.click(changeAccountLink);
        for (WebElement option : action.getOptionsInSelect(changeAccountSelect)) {
            if (option.getText().contains(accountName)) {
                return true;
            }
        }
        return false;
    }
}
