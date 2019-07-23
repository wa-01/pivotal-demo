package com.jalasoft.pivotal.steps;


import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.account.AddAccount;
import com.jalasoft.pivotal.pages.account.Dashboard;
import com.jalasoft.pivotal.pages.account.DetailsAccount;
import com.jalasoft.pivotal.pages.account.SettingsAccount;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.*;


public class AccountSteps {
    private Header header;
    private Dashboard actdashboard;
    private AddAccount addAccount;
    private DetailsAccount detailsAccount;
    private SettingsAccount settingsAccount;

    public AccountSteps(Header header, Dashboard actdashboard, AddAccount addAccount, DetailsAccount detailsAccount, SettingsAccount settingsAccount) {
        this.header = header;
        this.actdashboard = actdashboard;
        this.addAccount = addAccount;
        this.detailsAccount = detailsAccount;
        this.settingsAccount=settingsAccount;
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
        settingsAccount = detailsAccount.clickSettingtab();
    }

    @When("I click delete link")
    public void i_click_delete_link() {
        settingsAccount.clickDeleteLink();
    }

    @Then("I validate the account name is {string} is not displayed")
    public void i_validate_the_account_name_is_is_not_displayed(String string) {
        assertFalse(actdashboard.accountIsNotDisplayed(string));
    }
}
