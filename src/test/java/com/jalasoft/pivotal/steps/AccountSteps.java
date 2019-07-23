package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;


public class AccountSteps {

    private ProfileDropdown profileDropdown;
    private Header header;
    private AccountPage accountPage;
    private ManageSpecificAccountPage manageSpecificAccountPage;
    private String accountID;

    public AccountSteps(ProfileDropdown profileDropdown, Header header, AccountPage accountPage, ManageSpecificAccountPage manageSpecificAccountPage){
        this.profileDropdown = profileDropdown;
        this.header=header;
        this.accountPage = accountPage;
        this.manageSpecificAccountPage = manageSpecificAccountPage;
    }

    @And("I create an account with :")
    public void iCreateAnAccountWith(Map<String, String> data) {
        profileDropdown=header.clickProfileDropdown();
        accountPage=profileDropdown.goToAccountPage();
       manageSpecificAccountPage= accountPage.createAccount(data);
    }

    @And("I select the tab {string}")
    public void iSelectTheTab(String option)
    {
        this.accountID=manageSpecificAccountPage.selectSettingsTab(option);


    }

    @When("I go to manage account page of {string}")
    public void iGoToManageAccountSettings(String accountName) {
        manageSpecificAccountPage=accountPage.goToAccountSpecificSettings(accountName);

    }

    @And("I click on delete account")
    public void iClickOnDeleteAccount() {
        accountPage=manageSpecificAccountPage.deleteAccount();

    }


    @Then("I validate the account with accountID is not present in account list")
    public void iValidateTheAccountWithNameIsNotPresentInAccountList() {

        assertFalse(accountPage.isAccountListed(accountID));

    }

    @And("I validate that account with name {string} is not present in new project form")
    public void iValidateThatAccountWithNameIsNotPresentInNewProjectForm(String arg0) {
    }

}
