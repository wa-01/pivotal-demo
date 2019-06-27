package com.jalasoft.pivotal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.jalasoft.pivotal.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.StringUtil;
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
        String expectedUserName = "albertcamacho04";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "Pass112233*+");

        // When

        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        data.put("project_name", "MyProjectAB");
        data.put("account", "account1");
        data.put("privacy", "public");

        projectForm.createProject(data);

        Project project = new Project();

        Assert.assertEquals(data.get("project_name"), project.getProjectName());

        String expected = "(" + StringUtils.capitalize(data.get("privacy")) +")";
        Assert.assertEquals(expected, project.getProjectPrivacy());

        ProjectSettings projectSettings = project.clickMoreTab();

        Assert.assertEquals(data.get("project_name"), projectSettings.getProjectTitle());
        Assert.assertTrue(projectSettings.getAccountLinkText().contains(data.get("account")));
        Assert.assertTrue(projectSettings.projectIsPublic());

    }

    @Test
    public void testAddHistory() {
        // Given
        String expectedUserName = "albertcamacho04";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "Pass112233*+");

        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        data.put("project_name", "MyProjectABCD");
        data.put("account", "account1");
        data.put("privacy", "public");

        projectForm.createProject(data);

        Story story = new Story();
        story.clickAddStoryBacklog();

        Map<String, String> storyData = new HashMap<>();
        data.put("title", "My first story");
        data.put("story_type", "bug");
        data.put("description", "A sort Description");
        data.put("save_description", "save");
        data.put("labels", "test, prod");
        story.saveStory(storyData);

    }
}
