package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Dashboard;
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
}
