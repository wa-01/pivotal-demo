package com.jalasoft.pivotal.pages.project;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSettings extends AbstractPage {

    private static final String OPTION_ACCOUNT_XPATH = "//select[@id='project_account_id_select']//option[contains(text(),'%s')]";

    @FindBy(css = "#project_name")
    private WebElement projectTitleTextBox;

    @FindBy(css = "a[href*='/accounts']")
    private WebElement accountLink;

    @FindBy(css = "#account_change_link")
    private WebElement accountChangeLink;

    @FindBy(css = "#project_public")
    private WebElement projectAccessCheckBox;

    public String getProjectTitleValue() {
        return action.getAttribute(projectTitleTextBox, "value");
    }

    public String getAccountText() {
        return action.getText(accountLink);
    }

    public boolean isProjectAccessCheckBox() {
        return action.isSelected(projectAccessCheckBox);
    }

    public boolean isProjectAccountAvailable(String expectedAccountName) {
        action.click(accountChangeLink);
        String optionAccountLocator = String.format(OPTION_ACCOUNT_XPATH, expectedAccountName);
        return driver.findElements(By.xpath(optionAccountLocator)).size() > 0;
    }

}
