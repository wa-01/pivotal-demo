package com.jalasoft.pivotal.steps;

import java.util.Map;

import com.jalasoft.pivotal.pages.project.ProjectDetails;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class ProjectSteps {

    private ProjectDetails projectDetails;

    private ProjectForm projectForm;

    public ProjectSteps(ProjectDetails projectDetails, ProjectForm projectForm) {
        this.projectDetails = projectDetails;
        this.projectForm = projectForm;
    }

    @And("I create the project with:")
    public void iSetTheProjectForm(Map<String, String> data) {
        projectDetails = projectForm.createProject(data);
    }

    @Then("I validate the project label is {string}")
    public void iValidateTheProjectLabelIs(String name) {
        String actualProjectName = projectDetails.getProjectNameLabel();
        Assert.assertEquals(actualProjectName, name);
    }
}
