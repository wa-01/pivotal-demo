package com.jalasoft.pivotal.steps;


import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.account.AddAccount;
import com.jalasoft.pivotal.pages.account.Dashboard;
import com.jalasoft.pivotal.pages.account.DetailsAccount;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;


public class AccountSteps {
    private Header header;
    private Dashboard actdashboard;
    private AddAccount addAccount;
    private DetailsAccount detailsAccount;

    public AccountSteps(Header header, Dashboard actdashboard, AddAccount addAccount, DetailsAccount detailsAccount) {
        this.header = header;
        this.actdashboard = actdashboard;
        this.addAccount = addAccount;
        this.detailsAccount = detailsAccount;
    }

    @Given("I click on Accounts")
    public void i_click_on_Accounts() {
        header.clickAccountOption();
    }

    @When("I click new account button")
    public void i_click_new_account_button() {
        actdashboard.clickCreateProjectButton();
    }

    @When("I create {string} account")
    public void i_create_account(String string) {
        addAccount.createAccount(string);
    }


    @Then("I validate the account name is {string}")
    public void i_validate_the_account_name_is(String string) {
        assertEquals(string, detailsAccount.getAccountName().toString());
    }

    @When("I click manage account button for {string} account")
    public void i_click_manage_account_button_for_account(String string) {
        detailsAccount.clickManageButton(string);
    }

    @When("I click settings tab")
    public void i_click_settings_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I click delete link")
    public void i_click_delete_link() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I validate the account name is {string} is not displayed")
    public void i_validate_the_account_name_is_is_not_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
