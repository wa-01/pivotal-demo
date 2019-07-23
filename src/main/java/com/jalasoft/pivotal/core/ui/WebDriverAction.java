package com.jalasoft.pivotal.core.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverAction {

    private WebDriver driver;
    private WebDriverWait wait;

    public WebDriverAction(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void click(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        locator.click();
    }

    public void setValue(By selector, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        driver.findElement(selector).sendKeys(value);
    }

    public void setValue(WebElement webElement, String value) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(value);
    }

    public String getText(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    public String getText(By selector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return driver.findElement(selector).getText();
    }

    public String getAttribute(WebElement webElement, String attribute) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getAttribute(attribute);
    }

    public String getAttribute(By selector, String attribute) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return driver.findElement(selector).getAttribute(attribute);
    }

    public boolean isSelected(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.isSelected();
    }

    public boolean isElementVisible(final By element) {
        try {
            driver.findElement(element);
        } catch (final NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void confirmDialog() {
        driver.switchTo().alert().accept();
    }

}
