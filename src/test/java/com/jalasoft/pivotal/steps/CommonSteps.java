package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.core.Environment;
import com.jalasoft.pivotal.pages.Signin;
import com.jalasoft.pivotal.pages.UserOption;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class CommonSteps {

    private Signin signin;
    private UserOption userOption;

    public CommonSteps(Signin signin) {
        this.signin = signin;
    }

    @Given("I sign in as {string}")
    public void iSignInAsUserAnd(String user) {
        String userName = Environment.getInstance().getValue(String.format("$['credentials']['%s']['username']", user));
        String password = Environment.getInstance().getValue(String.format("$['credentials']['%s']['password']", user));
        signin.loginAs(userName, password);
    }
    @And("I click the CREATE ACCOUNT button")
    public void iClickTheCreateAccount(){
        userOption.SelectAccount();
    }
}
