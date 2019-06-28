package com.jalasoft.pivotal.pages.project;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoreTab extends AbstractPage {

    public void goToSidebarOption(String option) {
        action.click(By.cssSelector(String.format("#%s", option)));
    }


}
