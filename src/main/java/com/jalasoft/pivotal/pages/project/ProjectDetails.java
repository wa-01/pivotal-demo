package com.jalasoft.pivotal.pages.project;

        import com.jalasoft.pivotal.pages.AbstractPage;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;

public class ProjectDetails extends AbstractPage {

    @FindBy(css = ".raw_context_name")
    private WebElement projectNameLabel;

    @FindBy(css = ".public_project_label")
    private WebElement projectPrivacyLabel;

    @FindBy(css = "#account_change_link")
    private WebElement changeAccountLink;

    @FindBy(css = "select#project_account_id_select")
    private WebElement selectAccount;

    private static final String ACCOUNT_NAME = "//option[contains(text(),'%s')]";

    public void goToTab(String tab) {
        action.click(By.cssSelector(String.format("a[data-aid='navTab-%s']", tab)));
    }

    public String getProjectNameLabel() {
        return action.getText(projectNameLabel);
    }

    public String getProjectPrivacyLabel() {
        return action.getText(projectPrivacyLabel).toLowerCase();
    }

    public boolean isAccountVisible(String accountName) {
        action.click(changeAccountLink);
        action.click(selectAccount);
        return action.isElementVisible(By.xpath(String.format(ACCOUNT_NAME, accountName)));
    }
}
