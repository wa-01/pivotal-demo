package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Dashboard;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class DashboardSteps {

    private Dashboard dashboard;

    public DashboardSteps(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    @When("I click the new project button")
    public void iClickTheNewProjectButton() {
        dashboard.clickCreateProjectButton();
    }

    @And("I search the project {string} in the dashboard")
    public void iSearchTheProject(String projectName) {
        dashboard.searchProjectWithName(projectName);
    }

    @And("I click project settings button of the {string} project")
    public void iClickProjectSettingsButtonOfTheProject(String projectName) {
        dashboard.clickProjectSettingsButton(projectName);
    }
}
