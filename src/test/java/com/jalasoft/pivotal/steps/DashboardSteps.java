package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class DashboardSteps {

    private Dashboard dashboard;
    private ProjectForm projectForm;

    public DashboardSteps(Dashboard dashboard, ProjectForm projectForm) {
        this.dashboard = dashboard;
        this.projectForm = projectForm;
    }

    @When("I click the new project button")
    public void iClickTheNewProjectButton() {
        dashboard.clickCreateProjectButton();
    }

    @When("I verify account {string} is not displayed in dropdown")
    public void iVerifyAccountNameIsNotDisplayed(String accountName) {
        assertFalse(projectForm.findAccount(accountName));
    }
}
