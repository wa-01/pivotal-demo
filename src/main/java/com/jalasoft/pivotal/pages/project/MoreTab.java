package com.jalasoft.pivotal.pages.project;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoreTab extends AbstractPage {

    public void goToMoreTab() {
        action.click(By.xpath(String.format("//a[@data-aid='navTab-more']//child::span")));
    }

}
