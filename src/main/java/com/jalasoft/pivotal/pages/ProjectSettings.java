package com.jalasoft.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSettings extends AbstractPage {
    @FindBy(css = "#project_name")
    private WebElement projectNameTextField;

    @FindBy(css = "a[href*='/accounts']")
    private WebElement accountHyperLink;

    @FindBy(css = "#project_public")
    private WebElement publicAccessCheckBox;

    public String getProjectTitle() {
        return action.getTextFieldValue(projectNameTextField);
    }

    public String getAccountLinkText() {
        return action.getText(accountHyperLink);
    }

    public boolean projectIsPublic() {
        return action.isSelected(publicAccessCheckBox);
    }

}
