package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Signin;
import cucumber.api.java.en.Given;

public class CommonSteps {

    private Signin signin;

    public CommonSteps(Signin signin) {
        this.signin = signin;
    }

    @Given("I sign in as {string} user and {string}")
    public void iSignInAsUserAnd(String userName, String password) {
        signin.loginAs(userName, password);
    }

}
