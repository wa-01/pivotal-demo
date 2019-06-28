package com.jalasoft.pivotal;

import com.jalasoft.pivotal.pages.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SigninTest {

    @Test
    public void testSignin () {
        // When
        String expectedUserName = "magalifa";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "");

        // Then
        ProfileDropdown profileDropdown = header.clickProfileDropdown();
        String actualResult = profileDropdown.getAvatarName();
        Assert.assertEquals(expectedUserName, actualResult);
    }

    @Test
    public void testCreateProject () {

        // Given
        String expectedUserName = "magalifa";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "BQEmagui1");

        // When

        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        String expectedProject = "MyProject";
        String expectedAccount = "account1";
        data.put("project_name", expectedProject);
        data.put("account", expectedAccount);
        projectForm.createProject(data);

        // Then
        String actualProjectName = projectForm.getProjectName();
        Assert.assertEquals(expectedProject, actualProjectName);


//        String actualPrivacy = projectForm.getProjectPrivacy();
//        Assert.assertEquals("(Public)", actualPrivacy);
        ProjectSettings projectSettings = projectForm.clickMoreLink();
        String actualProjectTitle = projectSettings.getProjectTitle();
        Assert.assertEquals(expectedProject, actualProjectTitle);

        String actualAccount = projectSettings.getAccount();
        Assert.assertTrue(actualAccount.contains(expectedAccount));

        projectSettings.deleteProject();

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
    public void testCreateStory () {

        // Given
        String expectedUserName = "magalifa";
        Signin signin = new Signin();
        signin.loginAs(expectedUserName, "");

        // When

        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        data.put("project_name", "MyProject");
        data.put("account", "account1");
        projectForm.createProject(data);
        StoryForm storyForm = projectForm.clickCreateStoryLink();
        Map<String, String> data1 = new HashMap<>();
        String expectedstoryName = "MyStory";
        data1.put("story_name", expectedstoryName);
        storyForm.createStory(data1);
        String actualResult = storyForm.getStoryName();
        Assert.assertEquals(expectedstoryName, actualResult);
    }
}
