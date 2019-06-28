package com.jalasoft.pivotal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.jalasoft.pivotal.pages.*;
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
    public void testAddStory() {
        // Given
        String expectedUserName = "josseccb";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "Control123");
        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        data.put("project_name", "MyProject1");
        data.put("account", "account1");
        projectForm.createProject(data);

        DashboardProject dashboardProject = new DashboardProject();
        StoryForm storyForm = dashboardProject.clickAddStoryButton();

        // When
        Map<String, String> storyFields = new HashMap<>();
        storyFields.put("story_title", "TEst story");
        storyFields.put("story_type", "feature");
        storyFields.put("points", "1 point");
        storyFields.put("requester", "josseccb");
        storyForm.addStory(data);
    }
}
