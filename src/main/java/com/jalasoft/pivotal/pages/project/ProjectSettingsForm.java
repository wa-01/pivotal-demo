package com.jalasoft.pivotal.pages.project;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSettingsForm extends AbstractPage {

    @FindBy (css = "a[id='account_change_link']")
    private WebElement changeAccountLink;

    @FindBy (css = "select[id='project_account_id_select']")
    private WebElement changeAccountList;

    public static final String ACCOUNT_NAME = "//option[contains(text(), '%s']";

    public void changeAccountLink(){
        action.click(changeAccountLink);
    }
    public void changeAccount(String storyType) {
        action.click(changeAccountList);
        action.click(By.xpath(String.format(ACCOUNT_NAME, storyType)));
    }
}
