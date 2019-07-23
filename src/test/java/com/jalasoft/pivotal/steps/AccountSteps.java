package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Account;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

public class AccountSteps {

    private Account account;

    public AccountSteps(Account account) {
        this.account = account;
    }
    @And("^I navigate to accounts manager$")
    public void iNavigateAccount(){
        account.goToAccountsPage();
   }

    @And("I create a new account {string}")
    public void iCreateANewAccount(String newAccount) {
        account.createAccount(newAccount);
    }

    @When("I click in {string} tab")
    public void iClickInTab(String tabName) {
        account.clickOnTab(tabName);
    }

    @And("I click in delete this account")
    public void iClickInDeleteThisAccount() {
        account.clickDeleteAccount();
    }

    @And("I confirm the deletion of the account")
    public void iConfirmTheDeletionOfTheAccount() {
        account.confirmAcoountDeletion();
    }

    @Then("I validate the account {string} was successfully deleted")
    public void iValidateTheAccountWasSuccessfullyDeleted(String accountName) {
        String expectedMessage = String.format("%s was successfully deleted.",accountName);
        assertEquals(expectedMessage, account.getAccountMessageDeletion());
    }
}
