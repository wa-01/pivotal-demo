package com.jalasoft.pivotal;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Test
    public void testLogin() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.pivotaltracker.com/");

        driver.findElement(By.cssSelector(".header__lg a[href=\"/blog\"] + a")).click();

        String userName = "carledriss";
        driver.findElement(By.cssSelector("#credentials_username")).sendKeys(userName);

        driver.findElement(By.cssSelector(".app_signin_action_button")).click();

        String password = "";
        driver.findElement(By.cssSelector("#credentials_password")).sendKeys(password);
        System.out.println("");
    }
}
