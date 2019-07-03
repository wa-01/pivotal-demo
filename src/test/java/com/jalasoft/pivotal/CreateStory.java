package com.jalasoft.pivotal;

import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.Signin;
import com.jalasoft.pivotal.pages.StoryForm;
import com.jalasoft.pivotal.pages.project.ProjectDetails;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import com.jalasoft.pivotal.pages.project.StoriesTab;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateStory {
    @Test
    public void testCreateStory() {
        // Given
        String userName = "magalifa";
        Signin signin = new Signin();
        signin.loginAs(userName, "BQEmagui1");

        // When
        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        data.put("name", "MyProjectAddStory1");
        data.put("account", "account1");
        data.put("privacy", "public");
        ProjectDetails projectDetails = projectForm.createProject(data);

        StoriesTab storiesTab = new StoriesTab();
        storiesTab.clickAddStoryButton("backlog");

        Map<String, String> data1 = new HashMap<>();
        data1.put("name", "MyProject");
        data1.put("story_type", "bug ");
        data1.put("description", "My description");
        data1.put("label", "Label Test");
        StoryForm storyForm = new StoryForm();
        storyForm.createStory(data1);
        String actualResult = storyForm.getStoryName();
        Assert.assertEquals(data1.get("name"), actualResult);


    }
}
