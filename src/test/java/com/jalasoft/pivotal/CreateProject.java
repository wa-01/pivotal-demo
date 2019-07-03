package com.jalasoft.pivotal;

import com.jalasoft.pivotal.pages.*;
import com.jalasoft.pivotal.pages.project.MoreTab;
import com.jalasoft.pivotal.pages.project.ProjectDetails;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import com.jalasoft.pivotal.pages.project.ProjectSettings;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateProject {

    @Test
    public void testCreateProject() {

        // Given
        String userName = "magalifa";
        Signin signin = new Signin();
        signin.loginAs(userName, "");

        // When
        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        data.put("name", "MyProject");
        data.put("account", "account1");
        data.put("privacy", "public");
        ProjectDetails projectDetails = projectForm.createProject(data);

        // Then
        // Project Details
        String actualProjectName = projectDetails.getProjectNameLabel();
        assertEquals(data.get("name"), actualProjectName);

        String actualProjectPrivacy = projectDetails.getProjectPrivacyLabel();
        assertEquals(String.format("(%s)", data.get("privacy")), actualProjectPrivacy);

        // Project Settings
        projectDetails.goToTab("more");
        MoreTab moreTab = new MoreTab();
        moreTab.goToSidebarOption("project_settings");

        ProjectSettings projectSettings = new ProjectSettings();
        actualProjectName = projectSettings.getProjectTitleValue();
        assertEquals(data.get("name"), actualProjectName);

        String actualAccount = projectSettings.getAccountText();
        assertTrue(actualAccount.contains(data.get("account")));

        assertTrue(projectSettings.isProjectAccessCheckBox());

        // Dashboard
        Header header = new Header();
        dashboard = header.goToDashboard();

        assertTrue(dashboard.isProjectVisible(data.get("name")));

        // Menu Popover
        MenuPopover menuPopover = header.clickPivotalTrackerDropDown();
        assertTrue(menuPopover.isProjectVisible(data.get("name")));
        actualProjectPrivacy = menuPopover.getPrivacyByProject(data.get("name"));
        assertEquals(String.format("(%s)", data.get("privacy")), actualProjectPrivacy);

        // Show All Projects
        ShowAll showAll = menuPopover.clickShowAllProjectsLink();
        assertTrue(showAll.isProjectVisible(data.get("name")));
        assertEquals(data.get("account"), showAll.getAccountByProject(data.get("name")));
    }
}
