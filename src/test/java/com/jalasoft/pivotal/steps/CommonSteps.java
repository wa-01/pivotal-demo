package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.core.Environment;
import com.jalasoft.pivotal.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.testng.Assert.assertEquals;

public class CommonSteps {

    private Signin signin;

    public CommonSteps(Signin signin) {
        this.signin = signin;
    }

    @Given("I sign in as {string}")
    public void iSignInAsUserAnd(String user) {
        String userName = Environment.getInstance().getValue(String.format("$['credentials']['%s']['username']", user));
        String password = Environment.getInstance().getValue(String.format("$['credentials']['%s']['password']", user));
        signin.loginAs(userName, password);
    }

    @And("I click the {string} item in the profile menu")
    public void iClickTheItemInTheProfileMenu(String option) {
        Header header = new Header();
        ProfileDropdown profileDropdown = header.clickProfileDropdown();
        profileDropdown.clickOption(option);
    }

    @Then("I validate the notice {string} is displayed")
    public void iValidateTheNoticeIsDisplayed(String notice) {
        NoticeBanner noticeBanner = new NoticeBanner();
        assertEquals(notice, noticeBanner.getNoticeText());
    }

    @And("I click Create Project button in the Pivotal Tracker dropdown")
    public void iClickInThePivotalTrackerDropdown() {
        Header header = new Header();
        MenuPopover menuPopover = header.clickPivotalTrackerDropDown();
        menuPopover.clickCreateProjectButton();
    }
}
