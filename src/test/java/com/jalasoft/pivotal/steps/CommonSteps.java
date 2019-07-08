package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Signin;
import cucumber.api.java.en.Given;

public class CommonSteps {

    @Given("I sign in as {string} user and {string}")
    public void iSignInAsUserAnd(String userName, String password) {
        Signin signin = new Signin();
        signin.loginAs(userName, password);
    }

}
