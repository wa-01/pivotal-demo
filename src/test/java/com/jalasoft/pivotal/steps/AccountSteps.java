package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.account.AccountsList;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class AccountSteps {
    private Header header;
    private AccountsList accountsList;

    public AccountSteps(Header header, AccountsList accountsList) {
        this.header = header;
        this.accountsList = accountsList;
    }

    @When("I create a new account called {string}")
    public void iCreateANewAccountCalled(String accountName) {
        this.header.clickProfileDropdown();
        this.accountsList.clickMenuLink("accounts");
        this.accountsList.createAccountClick();
        this.accountsList.setAccountName(accountName);
        this.accountsList.createClick();
    }

    @Then("I should see the {string} label")
    public void iShouldSeeTheLabel(String accountName) {
        String actualAccountName = this.accountsList.getAccountNameLabel();
        assertEquals(actualAccountName, accountName);
    }

    @When("I delete the account created")
    public void iDeleteTheAccountCreated() {
        this.accountsList.clickOnSettingsTab("Settings");
        this.accountsList.deleteAccount("delete this account");
        this.accountsList.confirmDelete();
    }

    @Then("I validate the message is {string}")
    public void iValidateTheMessageIs(String message) {
        String actualConfirmationMessage = this.accountsList.getConfirmationMessage();
        assertEquals(actualConfirmationMessage, message);
    }

    @And("I validate the {string} account is not displayed in the accounts list")
    public void iValidateTheAccountIsNotDisplayedInTheAccountsList(String accountName) {
        boolean actual = this.accountsList.isAccountVisible(accountName);
        assertFalse(actual);
    }
}
