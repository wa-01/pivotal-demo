package com.jalasoft.pivotal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.ProfileDropdown;
import com.jalasoft.pivotal.pages.ProjectForm;
import com.jalasoft.pivotal.pages.Signin;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SigninTest {

    @Test
    public void testSignin() {
        // When
        String expectedUserName = "mauricioramirez1";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "59334499");

        // Then
        ProfileDropdown profileDropdown = header.clickProfileDropdown();
        String actualResult = profileDropdown.getAvatarName();
        Assert.assertEquals(expectedUserName, actualResult);
    }

    @Test
    public void testCreateProject() {

        // Given
        String expectedUserName = "mauricioramirez1";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "59334499");

        // When

        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

//        Map<String, String> data = new HashMap<>();
//        data.put("project_name", "MyProject");
//        data.put("account", "account1");
//        data.put("privacy", "public");

        Map<String, String> data = new HashMap<>();
        Random rand = new Random();
        data.put("project_name", "MyProject" + rand.nextInt(400));
        data.put("account", "test_account");
        projectForm.createProject(data);

        String text = header.getLogoButtonText();

        System.out.print(text);

        // Then
//        String actualProjectName = driver.findElement(By.cssSelector(".raw_context_name")).getText();
//        Assert.assertEquals(expectedProject, actualProjectName);
//
//        String actualPrivacy = driver.findElement(By.cssSelector(".public_project_label")).getText();
//        Assert.assertEquals("(Public)", actualPrivacy);
//
//        driver.findElement(By.cssSelector("a[href*=\"/settings\"] > span")).click();
//
//        actualProjectName = driver.findElement(By.cssSelector("#project_name")).getAttribute("value");
//        Assert.assertEquals(expectedProject, actualProjectName);
//
//        String actualAccount = driver.findElement(By.cssSelector("a[href*='/accounts']")).getText();
//        Assert.assertTrue(actualAccount.contains(expectedAccount));
//
//        Assert.assertTrue(driver.findElement(By.cssSelector("#project_public")).isSelected());
    }
}
