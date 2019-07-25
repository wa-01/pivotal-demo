package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.core.Environment;
import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.ProfileDropdown;
import com.jalasoft.pivotal.pages.Signin;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class CommonSteps {

    private Signin signin;
    private Header header;
    private ProfileDropdown profileDropdown;

    public CommonSteps(Signin signin, Header header, ProfileDropdown profileDropdown) {
        this.signin = signin;
        this.header = header;
        this.profileDropdown = profileDropdown;
    }

    @Given("I sign in as {string}")
    public void iSignInAsUserAnd(String user) {
        String userName = Environment.getInstance().getValue(String.format("$['credentials']['%s']['username']", user));
        String password = Environment.getInstance().getValue(String.format("$['credentials']['%s']['password']", user));
        signin.loginAs(userName, password);
    }

    @And("I go to the dashboard")
    public void iGoToTheDashboard() {
        header.goToDashboard();
    }

    @And("I Go to account menu")
    public void iGoToAccountMenu() {
        header.clickProfileDropdown();
        profileDropdown.clickOnDropDownOption("Accounts");
    }
}
