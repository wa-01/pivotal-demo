package com.jalasoft.pivotal.steps;


import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.account.AddAccount;
import com.jalasoft.pivotal.pages.account.DashboardAccount;
import com.jalasoft.pivotal.pages.account.DetailsAccount;
import com.jalasoft.pivotal.pages.account.SettingsAccount;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.*;


public class AccountSteps {
    public String actName;
    private Header header;
    private DashboardAccount actdashboard;
    private AddAccount addAccount;
    private DetailsAccount detailsAccount;
    private SettingsAccount settingsAccount;
    private Dashboard dashboard;

    public AccountSteps(Header header, DashboardAccount actdashboard,
                        AddAccount addAccount, DetailsAccount detailsAccount,
                        SettingsAccount settingsAccount, Dashboard dashboard) {
        this.header = header;
        this.actdashboard = actdashboard;
        this.addAccount = addAccount;
        this.detailsAccount = detailsAccount;
        this.settingsAccount = settingsAccount;
        this.dashboard = dashboard;
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
    public void i_create_account(String accountName) {
        addAccount.createAccount(accountName);

    }

    @Then("I validate the account name is {string}")
    public void i_validate_the_account_name_is(String accountName) {
        assertEquals(accountName, detailsAccount.getAccountName().toString());
    }

    @When("I click manage account button for {string} account")
    public void i_click_manage_account_button_for_account(String accountName) {
        actdashboard.clickManageButton(accountName);
    }

    @When("I click settings tab")
    public void i_click_settings_tab() {
        settingsAccount = detailsAccount.clickSettingtab();
    }

    @When("I click delete link")
    public void i_click_delete_link() {
        settingsAccount.clickDeleteLink();
    }

    @Then("I validate the {string} is not displayed")
    public void i_validate_the_is_not_displayed(String accountName) {
        //assertFalse(actdashboard.accountIsNotDisplayed(accountName));
        assertFalse(actdashboard.accountDisplayed(accountName));
    }

    @And("I validate a delete {string} message is displayed")
    public void i_validate_a_delete_message_is_displayed(String accountName) {
        assertTrue(actdashboard.deleteAccountMessageIsDisplayed(accountName));
    }

    @And("I validate {string} is not displayed on create project form")
    public void iValidateIsNotDisplayedOnCreateProjectForm(String accountName) {
        header.goToDashboard();
        assertFalse(dashboard.clickCreateProjectButton(accountName).searchAccount(accountName));
    }

    @And("I validate {string} is not displayed on {string} more tab")
    public void iValidateIsNotDisplayedOnMoreTab(String accountName, String projectName) {
        header.goToDashboard();
        assertFalse(dashboard.clickProject(projectName).searchAccount(accountName));
    }
}
