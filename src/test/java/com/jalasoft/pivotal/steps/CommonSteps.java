package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.core.Environment;
import com.jalasoft.pivotal.core.ui.SharedDriver;
import com.jalasoft.pivotal.pages.Signin;
import cucumber.api.java.en.Given;

public class CommonSteps {

    private Signin signin;

    public CommonSteps(final SharedDriver sharedDriver, Signin signin) {
        this.signin = signin;
    }

    @Given("I sign in as {string}")
    public void iSignInAsUserAnd(String user) {
        String userName = Environment.getInstance().getValue(String.format("$['credentials']['%s']['username']", user));
        String password = Environment.getInstance().getValue(String.format("$['credentials']['%s']['password']", user));
        signin.loginAs(userName, password);
    }

}
