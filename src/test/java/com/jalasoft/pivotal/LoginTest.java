package com.jalasoft.pivotal;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
//        driver.findElement(By.xpath("//div[@class='header__lg']/a[contains(@href, \"/signin\")]")).click();

        String expectedUserName = "Carledriss";
        driver.findElement(By.cssSelector("#credentials_username")).sendKeys(expectedUserName);
//        driver.findElement(By.xpath("//input[@id='credentials_username']")).sendKeys(expectedUserName);

        driver.findElement(By.cssSelector(".app_signin_action_button")).click();
//        driver.findElement(By.xpath("//input[@class='app_signin_action_button']")).click();

        String password = "";
        driver.findElement(By.cssSelector("#credentials_password")).sendKeys(password);

        driver.findElement(By.cssSelector(".app_signin_action_button")).click();

        // Then
        driver.findElement(By.cssSelector("div[data-aid=\"ProfileDropdown\"] > button")).click();
        String actualResult = driver.findElement(By.cssSelector(".AvatarDetails__name")).getText();
        Assert.assertEquals(expectedUserName, actualResult);

        System.out.println("");
    }
}
