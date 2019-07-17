package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.Signin;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import cucumber.api.java.en.When;

public class DashboardSteps {

    private Dashboard dashboard;

    public DashboardSteps(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    @When("I click the new project button")
    public void iClickTheNewProjectButton() {
        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();
    }
}
