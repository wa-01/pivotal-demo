package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.account.AccountSettingsPage;
import com.jalasoft.pivotal.pages.account.AccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.Assert.assertEquals;

public class AccountSteps {
    private AccountPage account;
    private AccountSettingsPage accountSettingsPage;

    public AccountSteps(AccountPage account, AccountSettingsPage accountSettingsPage) {
        this.account = account;
        this.accountSettingsPage = accountSettingsPage;
    }


    @And("click on Create Account button")
    public void clickOnCreateAccountButton() {
        account.clickCreateAccountButton();
    }

    @And("I create the account with name:")
    public void iCreateTheAccountWith(String data) {
        account.createAccount(data);
    }

    @When("I click the account Settings")
    public void iClickTheAccountSettings() {
        accountSettingsPage.clickAccountSettings();
    }

    @And("I click on  delete this account link")
    public void iClickOnDeleteThisAccountLink() {
        accountSettingsPage.clickDeleteAccountLink();
    }

    @And("I accept the pop up")
    public void iAcceptPopUp() {
        accountSettingsPage.AcceptPopUp();
    }

    @Then("I validate the message is {string}")
    public void iValidateTheMessageIs(String message) {
        String actualSuccesMessage = accountSettingsPage.getSuccessMessage();
        assertEquals(actualSuccesMessage,message);
    }
}
