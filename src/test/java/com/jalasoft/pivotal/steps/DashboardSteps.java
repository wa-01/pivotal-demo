package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.ProfileDropdownOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class DashboardSteps {

    private Dashboard dashboard;
    private Header header;
    private ProfileDropdownOptions profileOptions;


    public DashboardSteps(Dashboard dashboard, Header header, ProfileDropdownOptions profileOptions) {
        this.dashboard = dashboard;
        this.header = header;
        this.profileOptions = profileOptions;
    }

    @When("I click the new project button")
    public void iClickTheNewProjectButton() {
        dashboard.clickCreateProjectButton();
    }


    @When("I click in the profile dropdown")
    public void iClickInTheProfileDropdown() {
        header.clickProfileDropDown();
    }


    @And("I click on the Accounts link")
    public void clickOnTheAccountsLink() {
      profileOptions.clickAccountOption();
    }
}
