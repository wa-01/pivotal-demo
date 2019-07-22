package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Accounts;
import com.jalasoft.pivotal.pages.Header;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class AccountSteps {

    private Header header;
    private Accounts accounts;

    public AccountSteps(Header header, Accounts accounts){
        this.header = header;
        this.accounts = accounts;
    }

    @When("I click the profile dropdown")
    public void iClickTheProfileDropdown() {
        header.clickProfileDropdown();
    }

    @And("I select Accounts")
    public void iClickTheAccountsOption(){
        header.clickDropdownAccounts();
    }

    @And("I click the Create Account button")
    public void iClickTheCreateAccountButton(){
        accounts.clickCreateAccount();
    }
}
