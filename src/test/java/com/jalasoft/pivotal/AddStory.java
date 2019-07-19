package com.jalasoft.pivotal;

import java.util.HashMap;
import java.util.Map;

import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.MenuPopover;
import com.jalasoft.pivotal.pages.ShowAll;
import com.jalasoft.pivotal.pages.Signin;
import com.jalasoft.pivotal.pages.StoryDetail;
import com.jalasoft.pivotal.pages.StoryForm;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import com.jalasoft.pivotal.pages.project.StoriesTab;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddStory {

    private Dashboard dashboard;

    private Map<String, String> projectData;

    @Before
    public void setUp() {
        // Given
        String userName = "Carledriss";
        Signin signin = new Signin();
        signin.loginAs(userName, "P@ssw0rd");

        dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        projectData = new HashMap<>();
        projectData.put("name", "MyProject123");
        projectData.put("account", "account1");
        projectData.put("privacy", "public");
        projectForm.createProject(projectData);
    }

    @Test
    public void testCreateStory() {
        // When
        StoriesTab projectPanel = new StoriesTab();
        StoryForm storyForm = projectPanel.clickAddStoryButton("backlog");
        Map<String, String> storyData = new HashMap<>();
        storyData.put("title", "new Story");
        storyData.put("story_type", "feature");
        storyData.put("points", "3");
        storyData.put("blockers", "blocker sample");
        storyData.put("description", "This is a description");
        storyData.put("labels", "label sample");
        storyData.put("tasks", "this is a sample task");
        storyData.put("comment", "ths is a sample comment");

        StoryDetail storyDetail = storyForm.saveStory(storyData);

        //Then
        assertEquals(storyData.get("title"), storyDetail.getStoryModelName(storyData.get("title")));

        // Show All Projects
        Header header = new Header();
        dashboard = header.goToDashboard();
        MenuPopover menuPopover = header.clickPivotalTrackerDropDown();
        ShowAll showAll = menuPopover.clickShowAllProjectsLink();

        assertEquals("1", showAll.getStoriesCountByProject(projectData.get("name")));
    }
}
