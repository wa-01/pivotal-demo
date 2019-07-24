package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.core.ui.DriverManager;
import com.jalasoft.pivotal.core.ui.WebDriverAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverAction action;

    private static final String base_url = "https://www.pivotaltracker.com/%s";

    public AbstractPage() {
        driver = DriverManager.getInstance().getDriver();
        wait = new WebDriverWait(driver, 30);
        action = new WebDriverAction(driver, wait);

        PageFactory.initElements(driver, this);
    }

    public void goToPage(String pageName) {
        String url = String.format(base_url, pageName);
        driver.get(url);

        //TODO: This should return a pageFactory
    }

}
