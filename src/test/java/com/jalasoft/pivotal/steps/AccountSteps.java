package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.account.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertFalse;

public class AccountSteps {
    private AccountsPage accountsPage;
    private AccountForm accountForm;
    private ManageAccount manageAccount;
    private AccountPlansBilling accountPlansBilling;
    private AccountSettings accountSettings;

    public AccountSteps(AccountsPage accountsPage,
                        AccountForm accountForm,
                        ManageAccount manageAccount,
                        AccountPlansBilling accountPlansBilling,
                        AccountSettings accountSettings) {
        this.accountsPage = accountsPage;
        this.accountForm = accountForm;
        this.manageAccount = manageAccount;
        this.accountPlansBilling = accountPlansBilling;
        this.accountSettings = accountSettings;
    }

    @Given("I click the create account button")
    public void iClickTheCreateAccountButton(){
        this.accountForm = this.accountsPage.clickCreateAccountBtn();
    }

    @And("I add a new account with name {string}")
    public void iAddANewAccountWithName(String name) {
        this.accountForm.setAccountName(name);
        this.manageAccount = accountForm.clickCreateButton();
    }

    @When("I click the {string} tab")
    public void iClickTheTab(String tabName) {
        this.manageAccount.clickOnTab(tabName);
    }

    @And("I click the delete account link and confirm with {string}")
    public void iClickTheDeleteAccountLinkAndConfirmWith(String actionBtn) {
        this.accountSettings.clickDeleteAndExecuteWith(actionBtn);
    }

    @And("I validate the {string} is not listed in the accounts page")
    public void iValidateTheIsNotInTheAccountsPage(String accountName) {
        assertFalse(this.accountsPage.listContainsTheAccount(accountName), "Account still exists");
    }
}
