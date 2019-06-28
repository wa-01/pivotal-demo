package com.jalasoft.pivotal;

import java.util.HashMap;
import java.util.Map;

import com.jalasoft.pivotal.pages.*;
import org.junit.Assert;
import org.junit.Test;

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
        String expectedUserName = "edgarriverq";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "Password1000");

        // When

        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        data.put("project_name", "MyProject01");
        data.put("account", "edgar2");
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
    public void testaddStory() {

        // Given
        String expectedUserName = "edgarriverq";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "Password1000");

        // When

        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        data.put("project_name", "MyProjectStory");
        data.put("account", "edgar2");
        projectForm.createProject(data);
        StoryForm storyForm = projectForm.clickAddStoryLink();
        Map<String, String> storydata = new HashMap<>();
        storydata.put("story_name", "MyStorytest");
        storyForm.createStory(storydata);

        //Then
        String storyNameBefore = "MyStorytest";
        String actualStoryName = storyForm.gettextStoryName();
        Assert.assertTrue(actualStoryName.equals(storyNameBefore));



    }
}

