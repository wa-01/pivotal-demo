package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.account.AccountsList;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

public class AccountSteps {
    private Header header;
    private AccountsList accountsList;

    public AccountSteps(Header header, AccountsList accountsList) {
        this.header = header;
        this.accountsList = accountsList;
    }

    @When("I click my username menu")
    public void iClickMyUsernameMenu() {
        this.header.clickProfileDropdown();
    }

    @And("I click {string} menu link")
    public void iClickMenuLink(String menuName) {
        this.accountsList.clickMenuLink(menuName);
    }

    @And("I click the create account button")
    public void iClickTheCreateAccountButton() {
        this.accountsList.createAccountClick();
    }

    @And("I enter the account name {string}")
    public void iEnterTheAccountName(String accountName) {
        this.accountsList.setAccountName(accountName);
    }

    @And("I click create button")
    public void iClickCreateButton() {
        this.accountsList.createClick();
    }

    @Then("I validate the account label is {string}")
    public void iValidateTheAccountLabelIs(String accountName) {
        String actualAccountName = this.accountsList.getAccountNameLabel();
        assertEquals(actualAccountName, accountName);
    }

    @When("I click the {string} tab button")
    public void iClickTheTabButton(String tabName) {
        this.accountsList.clickOnSettingsTab(tabName);
    }

    @And("I click the {string} link")
    public void iClickTheLink(String text) {
        this.accountsList.deleteAccount(text);
    }

    @And("I click the OK button to confirm")
    public void iClickTheButtonToConfirm() {
        this.accountsList.confirmDelete();
    }

    @Then("I validate the confirmation label is {string}")
    public void iValidateTheConfirmationLabelIs(String message) {
        String actualConfirmationMessage = this.accountsList.getConfirmationMessage();
        assertEquals(actualConfirmationMessage, message);
    }
}
