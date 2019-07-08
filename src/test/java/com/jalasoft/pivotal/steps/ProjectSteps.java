package com.jalasoft.pivotal.steps;

import java.util.List;
import java.util.Map;

import com.jalasoft.pivotal.pages.project.ProjectDetails;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

public class ProjectSteps {

    ProjectDetails projectDetails;

    @And("I set the project form")
    public void iSetTheProjectForm(Map<String, String> data) {
//    public void iSetTheProjectForm(List<Map<String, String>> dataList) {
        ProjectForm projectForm = new ProjectForm();
        projectDetails = projectForm.createProject(data);
    }

    @Then("I validate the project label is {string}")
    public void iValidateTheProjectLabelIs(String name) {
        String actualProjectName = projectDetails.getProjectNameLabel();
        Assert.assertEquals(actualProjectName, name);
    }
}
