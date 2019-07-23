package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class AccountSteps {


    private Header header;
    private ProfileDropdown profileDropdown;
    private UserManagementHeader userManagementHeader;
    private AccountsPanel accountsPanel;
    private AccountDetail accountDetail;

    public AccountSteps( Header header, ProfileDropdown profileDropdown, UserManagementHeader userManagementHeader, AccountsPanel accountsPanel, AccountDetail accountDetail){
        this.accountsPanel = accountsPanel;
        this.accountDetail = accountDetail;
        this.userManagementHeader = userManagementHeader;
        this.profileDropdown = profileDropdown;
        this.header = header;

    }

    @And("I create an account with {string} as name")
    public void iCreateAnAccountWithAsName(String accountName) {
        header.clickProfileDropdown();
        profileDropdown.clickOnDropDownOption("Accounts");
        userManagementHeader.clickAccountOption();
        accountsPanel.createAccount(accountName);
        assertEquals(accountName, accountDetail.getAccountName());
        userManagementHeader.clickAccountOption();
    }

    @When("I click the manage option of the {string}")
    public void iSelectThe(String accountName) {
        accountsPanel.selectAccount(accountName);
    }

    @And("I click settings option")
    public void iClickSettingsOption() {
        accountDetail.clickSubnaveOption("Settings");
    }

    @Then("I delete the account")
    public void iDeleteTheAccount() {
        accountDetail.deleteAccount();
    }

    @Then("I verify the account named as {string} is not found")
    public void iVerifyTheAccountNamedAsIsNotFound(String accountName) {
        assertFalse(accountsPanel.isAccountNameVisible(accountName));
    }
}
