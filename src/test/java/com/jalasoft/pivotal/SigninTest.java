package com.jalasoft.pivotal;

import java.util.HashMap;
import java.util.Map;
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
        String expectedUserName = "Carledriss";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "");

        // Then
        ProfileDropdown profileDropdown = header.clickProfileDropdown();
        String actualResult = profileDropdown.getAvatarName();
        Assert.assertEquals(expectedUserName, actualResult);
    }

    @Test
    public void testCreateProject() {

        // Given
        String expectedUserName = "Carledriss";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "");

        // When

        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        data.put("project_name", "MyProject");
        data.put("account", "account1");
//        data.put("privacy", "public");

//        Map<String, String> data = new HashMap<>();
//        data.put("project_name", "MyProject");
//        data.put("account", "account1");
        projectForm.createProject(data);

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

    @Test
    public void testAddStoryForm(){
        // given
        String expectedUserName = "rubenmendoza";
        String expectedPassword = "p1v0t4Labc";
        String expectedProjectStoryName = "My Project Story";
        String expectedStoryDescription = "This is my web automation test project";
        String expectedStoryLabel = "Label of my Project";

        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, expectedPassword);

        // when
        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.selectProject();
        projectForm = dashboard.clickAddStory();

        Map<String, String> data = new HashMap<>();
        data.put("storyName", expectedProjectStoryName);
        data.put("description", expectedStoryDescription);
        data.put("label", expectedStoryLabel);

        projectForm.addStoryForm(data);

    }
}
