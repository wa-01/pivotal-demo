package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.ProfileDropdown;
import cucumber.api.java.en.When;

public class HeaderSteps {

    private Header header;
    private ProfileDropdown profileDropdown;


    public HeaderSteps(Header header, ProfileDropdown profileDropdown) {
        this.header = header;
        this.profileDropdown = profileDropdown;
    }

    @When("I click profile dropdown button")
    public void iClickProfileDropdownButton() {
        ProfileDropdown profileDropdown = header.clickProfileDropdown();
    }

    @When("I go to accounts")
    public void iGoToAccounts() {
        ProfileDropdown profileDropdown = header.clickProfileDropdown();
        profileDropdown.clickAccounts();
    }

    @When("I go to dashboard")
    public void iGoToDashboard() {
        header.goToDashboard();
    }
}
