package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.ProfileDropdown;
import cucumber.api.java.en.When;

import java.util.Map;

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
}
