package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.*;

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

    @And("I click settings option in the account manage")
    public void iClickSettingsOptionInTheAccountManage() {
        accountDetail.clickSubNaveOption("Settings");
    }


    @Then("I verify the account named as {string} is not found in account panel")
    public void iVerifyTheAccountNamedAsIsNotFoundInAccountPanel(String accountName) {
        assertFalse(accountsPanel.isAccountNameVisible(accountName));
    }

    @And("I click delete account link in the account manage panel")
    public void iClickDeleteAccountLinkInTheAccountManagePanel() {
        accountDetail.deleteAccount();
    }

    @And("I verify the delete notification is displayed")
    public void iVerifyTheDeleteNotificationIsDisplayed() {
        assertTrue(accountDetail.deleteNotificationIsDisplayed());
    }

    @And("I click accept delete account button")
    public void iClickAcceptDeleteAccountButton() {
        accountDetail.acceptDeleteNotification();
    }
}
