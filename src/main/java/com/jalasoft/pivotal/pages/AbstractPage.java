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

    public AbstractPage() {
        driver = DriverManager.getInstance().getDriver();
        wait = new WebDriverWait(driver, 30);
        action = new WebDriverAction(driver, wait);

        PageFactory.initElements(driver, this);
    }

}
