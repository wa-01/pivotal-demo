package com.jalasoft.pivotal.pages;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Signin {

    private WebDriver driver;

    public Signin() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("https://www.pivotaltracker.com/signin?source=navbar");
    }

    public void setUserName(String userName) {
        driver.findElement(By.cssSelector("#credentials_username")).sendKeys(userName);
    }

    public void clickNextButton() {
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
