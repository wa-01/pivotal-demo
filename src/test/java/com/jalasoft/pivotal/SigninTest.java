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
        String expectedUserName = "emelyllanos";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "Control123");

        // Then
        ProfileDropdown profileDropdown = header.clickProfileDropdown();
        String actualResult = profileDropdown.getAvatarName();
        Assert.assertEquals(expectedUserName, actualResult);
    }
/*
    @Test
    public void testCreateProject() {

        // Given
        String expectedUserName = "emelyllanos";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "Control123");

        // When
        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        data.put("project_name", "MyProject4");
        data.put("account", "account1");
        data.put("privacy", "public");
        projectForm.createProject(data);

        StoryForm storyForm = dashboard.clickFirstStoryAddButton();

        Map<String, String> storyData = new HashMap<>();
        storyData.put("story_name", "MyStory4");
        storyData.put("description_edit", "account1");
        storyData.put("blocker_edit","new blocker");
        storyData.put("add_task","myNew task1");
        storyData.put("story_type", "feature");
        storyData.put("story_owner", "emelyllanos");
   //     storyData.put("label_search", "Label25");
        storyData.put("comment_text_area","this is a comment");

        storyForm.createStory(storyData);
    }
*/
    @Test
    public void testCreateStory() {

        // Given
        String expectedUserName = "emelyllanos";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "Control123");

        // When
        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        data.put("project_name", "MyProject7");
        data.put("account", "account1");
        data.put("privacy", "public");
        projectForm.createProject(data);

        StoryForm storyForm = dashboard.clickFirstStoryAddButton();

        Map<String, String> storyData = new HashMap<>();
        storyData.put("story_name", "MyStory7");
        storyData.put("description_edit", "account1");
        storyData.put("blocker_edit","new blocker");
        storyData.put("add_task","myNew task1");
        storyData.put("story_type", "feature");
        storyData.put("story_owner", "emelyllanos");
        //     storyData.put("label_search", "Label25");
        storyData.put("comment_text_area","this is a comment");
        storyForm.createStory(storyData);

        //Then
        CurrentBacklog currentBacklog = storyForm.getCurrentBacklog();
        String expectedStoryName = "MyStory7";
        Assert.assertEquals(currentBacklog.getStoryName(), expectedStoryName);

    }
}
