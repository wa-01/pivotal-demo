package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.ProfileDropdownList;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class DashboardSteps {

    private Dashboard dashboard;
    private Header header;
    private ProfileDropdownList profileOptions;


    public DashboardSteps(Dashboard dashboard, Header header, ProfileDropdownList profileOptions) {
        this.dashboard = dashboard;
        this.header = header;
        this.profileOptions = profileOptions;
    }

    @When("I click the new project button")
    public void iClickTheNewProjectButton() {
        dashboard.clickCreateProjectButton();
    }


    @When("I click in the profile dropdown button")
    public void iClickInTheProfileDropdown() {
        header.clickProfileDropDown();
    }


    @And("click on the Accounts link")
    public void clickOnTheAccountsLink() {
      profileOptions.clickAccountOption();
    }
}
