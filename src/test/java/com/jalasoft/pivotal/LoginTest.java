package com.jalasoft.pivotal;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {

    @Test
    public void testLogin() {

        // Given
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.pivotaltracker.com/");

        // When
        driver.findElement(By.cssSelector(".header__lg a[href=\"/blog\"] + a")).click();
//        driver.findElement(By.xpath("//div[@class='header__lg']/a[contains(@href, \"/blog\") + a")).click();

        String userName = "mauricioramirez1";
        driver.findElement(By.cssSelector("#credentials_username")).sendKeys(userName);

        driver.findElement(By.cssSelector(".app_signin_action_button")).click();

        String password = "59334499";
        driver.findElement(By.cssSelector("#credentials_password")).sendKeys(password);
        System.out.println("");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector(".app_signin_action_button")).click();

        // Then
        driver.findElement(By.cssSelector("div[data-aid=\"ProfileDropdown\"] > button")).click();

        String actualResult = driver.findElement(By.cssSelector(".AvatarDetails__username")).getText();
        actualResult = actualResult.replace("@", "");
        String expectedResult = userName;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCreateProject() {

        // Given
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.pivotaltracker.com/");

        // When
        driver.findElement(By.cssSelector(".header__lg a[href=\"/blog\"] + a")).click();
//        driver.findElement(By.xpath("//div[@class='header__lg']/a[contains(@href, \"/blog\") + a")).click();

        String userName = "mauricioramirez1";
        driver.findElement(By.cssSelector("#credentials_username")).sendKeys(userName);

        driver.findElement(By.cssSelector(".app_signin_action_button")).click();

        String password = "59334499";
        driver.findElement(By.cssSelector("#credentials_password")).sendKeys(password);
        System.out.println("");

        driver.findElement(By.cssSelector(".app_signin_action_button")).click();

        driver.findElement(By.cssSelector("#create-project-button")).click();

        driver.findElement(By.cssSelector("input[name='project_name'])"));
    }
}
