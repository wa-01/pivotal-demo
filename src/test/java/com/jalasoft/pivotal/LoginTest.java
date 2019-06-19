package com.jalasoft.pivotal;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

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

        String userName = "mauricioramirez1";
        driver.findElement(By.cssSelector("#credentials_username")).sendKeys(userName);

        driver.findElement(By.cssSelector(".app_signin_action_button")).click();

        String password = "59334499";
        driver.findElement(By.cssSelector("#credentials_password")).sendKeys(password);

        driver.findElement(By.cssSelector(".app_signin_action_button")).click();

        // Then
        driver.findElement(By.cssSelector("div[data-aid=\"ProfileDropdown\"] > button")).click();

        String actualResult = driver.findElement(By.cssSelector(".AvatarDetails__username")).getText();
        actualResult = actualResult.replace("@", "");

        Assert.assertEquals(userName, actualResult);
    }

    @Test
    public void testCreateProject() {

        // Given
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.pivotaltracker.com/");

        driver.findElement(By.cssSelector(".header__lg a[href=\"/blog\"] + a")).click();

        String expectedUserName = "mauricioramirez1";
        driver.findElement(By.cssSelector("#credentials_username")).sendKeys(expectedUserName);

        driver.findElement(By.cssSelector(".app_signin_action_button")).click();

        String password = "59334499";
        driver.findElement(By.cssSelector("#credentials_password")).sendKeys(password);

        driver.findElement(By.cssSelector(".app_signin_action_button")).click();

        // When

        driver.findElement(By.cssSelector("#create-project-button")).click();

        String projectName = "MyProject";
        driver.findElement(By.cssSelector("input[name=\"project_name\"]")).sendKeys(projectName);

//        driver.findElement(By.cssSelector(".tc-account-selector__header")).click();

        driver.findElement(By.cssSelector("div[data-aid=\"account-selector\"]")).click();

        driver.findElement(By.xpath("//div[@class='tc-account-selector__option-account-name' and text()='test_account']")).click();

        driver.findElement(By.cssSelector("input[data-aid=\"public\"]")).click();

        driver.findElement(By.cssSelector("[data-aid=\"FormModal__submit\"]")).click();

        // Then

        String actualValue = driver.findElement(By.cssSelector(".tc_context_name > .raw_context_name")).getText();
        Assert.assertEquals(projectName, actualValue);

        actualValue = driver.findElement(By.cssSelector(".tc_context_name > .public_project_label")).getText();
        Assert.assertEquals("(Public)", actualValue);

        actualValue = driver.findElement(By.cssSelector("li.raw_context_name"))



    }
}
