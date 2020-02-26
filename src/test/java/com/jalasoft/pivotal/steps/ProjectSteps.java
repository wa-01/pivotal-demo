package com.jalasoft.pivotal.steps;

import java.util.Map;

import com.jalasoft.pivotal.core.ui.SharedDriver;
import com.jalasoft.pivotal.pages.StoryDetail;
import com.jalasoft.pivotal.pages.StoryForm;
import com.jalasoft.pivotal.pages.project.ProjectDetails;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import com.jalasoft.pivotal.pages.project.StoriesTab;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectSteps {

    private ProjectDetails projectDetails;

    private ProjectForm projectForm;

    private StoriesTab storiesTab;

    private StoryForm storyForm;

    private StoryDetail storyDetail;

    public ProjectSteps(final SharedDriver sharedDriver, ProjectDetails projectDetails, ProjectForm projectForm,
                        StoriesTab storiesTab, StoryForm storyForm, StoryDetail storyDetail) {
        this.projectDetails = projectDetails;
        this.projectForm = projectForm;
        this.storiesTab = storiesTab;
        this.storyForm = storyForm;
        this.storyDetail = storyDetail;
    }

    @And("I create the project with:")
    public void iSetTheProjectForm(Map<String, String> data) {
        projectDetails = projectForm.createProject(data);
    }

    @Then("I validate the project label is {string}")
    public void iValidateTheProjectLabelIs(String name) {
        String actualProjectName = projectDetails.getProjectNameLabel();
        assertTrue(actualProjectName.contains(name));
    }

    @When("I click the add story button on {string} panel")
    public void iClickTheAddStoryButtonOnPanel(String panel) {
        storiesTab.clickAddStoryButton(panel);
    }

    @And("I add the story with:")
    public void iAddTheStoryWith(Map<String, String> data) {
        storyForm.saveStory(data);
    }

    @Then("I validate the story label is {string}")
    public void iValidateTheStoryLabelIs(String storyName) {
        assertEquals(storyName, storyDetail.getStoryModelName(storyName));
    }
}
