package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Accounts;
import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.project.MoreTab;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class AccountSteps {

    private Header header;
    private Accounts accounts;
    private MoreTab moreTab;

    public AccountSteps(Header header, Accounts accounts, MoreTab moreTab){
        this.header = header;
        this.accounts = accounts;
        this.moreTab = moreTab;
    }

    @And("I click the profile dropdown")
    public void iClickTheProfileDropdown() {
        header.clickProfileDropdown();
    }

    @And("I select Accounts")
    public void iClickTheAccountsOption(){
        header.clickDropdownAccounts();
    }

    @And("I click the \"Create Account\" button")
    public void iClickTheCreateAccountButton(){
        accounts.clickCreateAccount();
    }

    @And("I create the Account with:")
    public void iSetAccountName(Map<String, String> data){
        accounts.setAccountName(data);
    }

    @And("I go to the \"Accounts\" page")
    public void iClickAccountsTab(){
        accounts.clickAccountsTab();
    }

    @When("I click {string} \"manage account\" button")
    public void iClickManageAccountButton(String accountName){
        accounts.clickManageAccountButton(accountName);
    }

    @And("I click the \"settings\" tab")
    public void iClickSettingsTab(){
        accounts.clickSettingsTab();
    }

    @And("I click the \"delete this account\" option")
    public void iClickDeleteAccount(){
        accounts.clickDeleteAccount();
    }

    @And("I accept the delete alert")
    public void iAcceptDeleteAccount(){
        accounts.acceptDeleteAlert();
    }

    @Then("I validate {string} account is not available in accounts list")
    public void iValidateAccountIsNotAvailable(String accountName) {
        assertFalse(accounts.checkAccountNameAvailability(accountName));
    }

    @And("I validate {string} account \"message was deleted\" is displayed")
    public void iValidateAccountDeletedMessageDisplayed(String accountName){
        String deletedMessage = accountName + " was successfully deleted.";
        assertEquals(deletedMessage, accounts.getDeletedMessage());
    }

    @And("I select a project")
    public void iSelectAProject(){
        accounts.selectProject();
    }

    @And("I select the \"More\" tab")
    public void iSelectMoreTab(){
        moreTab.goToMoreTab();
    }

    @And("I validate {string} account is not available in \"Project Settings\" dropdown")
    public void iValidateAccountIsNotAvailableInProjectSetting(String accountName){
        accounts.getProjectSettingsAccountsList();
        assertFalse(accounts.checkAccountInProjectSetting(accountName));
    }

    @And("I click the header Project dropdown")
    public void iClickTheHeaderProjectDropdown(){
        header.clickPivotalTrackerDropDown();
    }

    @And("I click the \"Create Project\" option")
    public void iClickTheCreateProjectOption(){
        header.clickTheCreateProjectOption();
    }

    @And("I validate {string} account is not available in \"Create a new project\" account dropdown")
    public void iValidateAccountIsNotAvailableInCreateProject(String accountName){
        header.checkAccountsFromCreateProject();
        assertFalse(accounts.checkAccountNameAvailability(accountName));
    }
}
