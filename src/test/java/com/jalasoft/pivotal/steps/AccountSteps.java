package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Header;
import cucumber.api.java.en.When;

public class HeaderSteps {

    private Header header;

    public HeaderSteps(Header header){
        this.header = header;
    }

    @When("I click the profile dropdown")
    public void iClickTheProfileButton() {
        header.clickProfileDropdown();
    }
}
