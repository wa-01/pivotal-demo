package com.jalasoft.pivotal.pages.project;

import com.jalasoft.pivotal.pages.AbstractPage;
import com.jalasoft.pivotal.pages.Dashboard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectDetails extends AbstractPage {

    @FindBy(css = ".raw_context_name")
    private WebElement projectNameLabel;

    @FindBy(css = ".public_project_label")
    private WebElement projectPrivacyLabel;

    @FindBy(css = "a[href='/dashboard']")
    private WebElement projectDashboardLink;




    public void goToTab(String tab) {
        action.click(By.cssSelector(String.format("a[data-aid='navTab-%s']", tab)));
    }

    public String getProjectNameLabel() {
        return action.getText(projectNameLabel);
    }

    public String getProjectPrivacyLabel() {
        return action.getText(projectPrivacyLabel).toLowerCase();
    }

    public Dashboard goToHome() {
        driver.get("https://www.pivotaltracker.com/dashboard");
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("a[href='/dashboard']")));
        //wait.until(ExpectedConditions.elementToBeClickable(projectDashboardLink));
        return  new Dashboard();
    }
}
