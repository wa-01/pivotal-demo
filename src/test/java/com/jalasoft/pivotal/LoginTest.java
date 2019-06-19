package com.jalasoft.pivotal;

import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

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

        String password = "P@ssw0rd";
        driver.findElement(By.cssSelector("#credentials_password")).sendKeys(password);

        driver.findElement(By.cssSelector(".app_signin_action_button")).click();

        // Then
        driver.findElement(By.cssSelector("div[data-aid=\"ProfileDropdown\"] > button")).click();
        String actualResult = driver.findElement(By.cssSelector(".AvatarDetails__name")).getText();
        Assert.assertEquals(expectedUserName, actualResult);

        System.out.println("");
    }

    @Test
    public void testCreateProject() {

        // Given
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.pivotaltracker.com/");

        driver.findElement(By.cssSelector(".header__lg a[href=\"/blog\"] + a")).click();

        String expectedUserName = "Carledriss";
        driver.findElement(By.cssSelector("#credentials_username")).sendKeys(expectedUserName);

        driver.findElement(By.cssSelector(".app_signin_action_button")).click();

        String password = "";
        driver.findElement(By.cssSelector("#credentials_password")).sendKeys(password);

        driver.findElement(By.cssSelector(".app_signin_action_button")).click();

        // When

        driver.findElement(By.cssSelector("#create-project-button")).click();

        String expectedProject = "MyProject";
        driver.findElement(By.cssSelector("input[name=\"project_name\"]")).sendKeys(expectedProject);

        driver.findElement(By.cssSelector(".tc-account-selector__header")).click();

        String expectedAccount = "account1";
        driver.findElement(By.xpath("//div[@class='tc-account-selector__option-account-name' and text()='" + expectedAccount + "']")).click();

        driver.findElement(By.cssSelector("input[data-aid=\"public\"]")).click();

        driver.findElement(By.cssSelector("[data-aid=\"FormModal__submit\"]")).click();

        // Then

        String actualProjectName = driver.findElement(By.cssSelector(".raw_context_name")).getText();
        Assert.assertEquals(expectedProject, actualProjectName);

        String actualPrivacy = driver.findElement(By.cssSelector(".public_project_label")).getText();
        Assert.assertEquals("(Public)", actualPrivacy);

        driver.findElement(By.cssSelector("a[href*=\"/settings\"] > span")).click();

        actualProjectName = driver.findElement(By.cssSelector("#project_name")).getAttribute("value");
        Assert.assertEquals(expectedProject, actualProjectName);

        String actualAccount = driver.findElement(By.cssSelector("a[href*='/accounts']")).getText();
        Assert.assertTrue(actualAccount.contains(expectedAccount));

        Assert.assertTrue(driver.findElement(By.cssSelector("#project_public")).isSelected());
    }
}
