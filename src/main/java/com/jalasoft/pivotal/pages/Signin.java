package com.jalasoft.pivotal.pages;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signin {

    private WebDriver driver;
    private WebDriverWait wait;

    public Signin() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);

        driver.manage().window().maximize();
        driver.get("https://www.pivotaltracker.com/signin?source=navbar");
    }

    public void setUserName(String userName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".app_signin_credentials_box + .app_signin_credentials_box ")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#credentials_username")));
        driver.findElement(By.cssSelector("#credentials_username")).sendKeys(userName);
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".app_signin_action_button")));
        driver.findElement(By.cssSelector(".app_signin_action_button")).click();
    }

    public void setPassword(String password) {
        driver.findElement(By.cssSelector("#credentials_password")).sendKeys(password);
    }

    public Header clickLoginButton() {
        driver.findElement(By.cssSelector(".app_signin_action_button")).click();
        return new Header(driver);
    }
}
