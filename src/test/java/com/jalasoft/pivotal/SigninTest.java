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
        String expectedUserName = "lufer.lfcc@gmail.com";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "Control123");

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
    public void testCreateStory() {
        // Given
        String expectedUserName = "lufer.lfcc@gmail.com";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "Control123");

        // When

        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        data.put("project_name", "MyProject4");
        data.put("account", "lufer1");
        data.put("privacy", "public");
        projectForm.createProject(data);

        //Then

        ProjectPanel projectPanel = new ProjectPanel();
        StoryForm storyForm = projectPanel.clickAddStoryBacklog();
        Map<String, String> StoryData = new HashMap<>();
        StoryData.put("title", "new Story");
        StoryData.put("description", "This is a description");
        StoryData.put("labels", "test");
        StoryData.put("story_type" , "Bug");
        StoryData.put("points" , "-1");

        storyForm.saveStory(StoryData);
    }
}
