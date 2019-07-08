package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;

public class ShowAll extends AbstractPage {

    public boolean isProjectVisible(String projectName) {
        return action.isElementVisible(By.xpath(String.format("//a[@class='project_name' and text() = '%s']", projectName)));
    }

    public String getAccountByProject(String projectName) {
        return action.getText(By.xpath(String.format("//a[@class='project_name' and text()='%s']/ancestor::li[contains(@class, 'project_row')]/descendant::a[contains(@href, '/account')]", projectName)));
    }

    public String getStoriesCountByProject(String projectName) {
        return action.getText(By.xpath(String.format("//a[@class='project_name' and text()='%s']/ancestor::li[contains(@class, 'project_row')]/descendant::div[contains(@class, 'stories')]", projectName)));
    }
}
