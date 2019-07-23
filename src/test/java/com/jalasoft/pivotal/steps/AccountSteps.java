package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.account.AccountDetail;
import com.jalasoft.pivotal.pages.account.AccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.*;

public class AccountSteps {
    private AccountPage account;
    private AccountDetail accountDetail;

    public AccountSteps(AccountPage account, AccountDetail accountDetail) {
        this.account = account;
        this.accountDetail = accountDetail;
    }


    @And("click on Create Account button")
    public void clickOnCreateAccountButton() {
        account.clickCreateAccountButton();
    }


    @And("I create the account with: {string}")
    public void iCreateTheAccountWith(String accountName) {
        account.createAccount(accountName);
    }

    @When("click in Settings")
    public void clickInSettings() {
        accountDetail.clickSettingsTab();
    }

    @And("click in delete this account link")
    public void clickInDeleteThisAccountLink() {
        accountDetail.clickDeleteAccountLink();
    }

    @Then("I validate the message is displayed {string}")
    public void iValidateTheMessageIsDisplayed(String expectedMessage) {
        assertEquals(expectedMessage, accountDetail.getAccountMessageDeleted());

    }

    @And("the account {string} is not present in Accounts")
    public void theAccountIsNotPresentInAccounts(String accountName) {
        assertFalse(accountDetail.isAccountVisible(accountName));
    }


}
