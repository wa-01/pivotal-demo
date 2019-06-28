package com.jalasoft.pivotal;

import java.util.HashMap;
import java.util.Map;

import com.jalasoft.pivotal.pages.*;
import org.apache.commons.lang3.StringUtils;
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
        String expectedUserName = "Carledriss";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "");

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

        String expected = "(" + StringUtils.capitalize(data.get("privacy")) + ")";
        Assert.assertEquals(expected, project.getProjectPrivacy());

        ProjectSettings projectSettings = project.clickMoreTab();

        Assert.assertEquals(data.get("project_name"), projectSettings.getProjectTitle());
        Assert.assertTrue(projectSettings.getAccountLinkText().contains(data.get("account")));
        Assert.assertTrue(projectSettings.projectIsPublic());

    }

    @Test
    public void testAddHistory() {
        // Given
        String expectedUserName = "Carledriss";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "");

        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        data.put("project_name", "MyProjectAA1");
        data.put("account", "account1");
        data.put("privacy", "public");

        projectForm.createProject(data);

        Story story = new Story();
        story.clickAddStoryBacklog();

        Map<String, String> storyData = new HashMap<>();
        storyData.put("title", "My first story");
        storyData.put("story_type", "bug");
        storyData.put("description", "A sort Description");
        storyData.put("labels", "test, prod");
        story.saveStory(storyData);

        Assert.assertEquals(storyData.get("title"), story.getStoryModelName(storyData.get("title")));
    }
}
