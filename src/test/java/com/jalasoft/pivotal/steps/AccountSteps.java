package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.account.AccountDetail;
import com.jalasoft.pivotal.pages.account.AccountPage;
import com.jalasoft.pivotal.pages.project.ProjectDetails;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class AccountSteps {
    private AccountPage account;
    private AccountDetail accountDetail;
    private Dashboard dashboard;
    private Header header;
    private ProjectForm projectForm;
    private ProjectDetails projectDetails;

    public AccountSteps(AccountPage account, AccountDetail accountDetail, Dashboard dashboard, Header header, ProjectForm projectForm, ProjectDetails projectDetails) {
        this.account = account;
        this.accountDetail = accountDetail;
        this.dashboard = dashboard;
        this.header = header;
        this.projectForm = projectForm;
        this.projectDetails = projectDetails;
    }


    @And("I click on Create Account button")
    public void clickOnCreateAccountButton() {
        account.clickCreateAccountButton();
    }


    @And("I create the account with: {string}")
    public void iCreateTheAccountWith(String accountName) {
        account.createAccount(accountName);
    }

    @When("I click in Settings")
    public void clickInSettings() {
        accountDetail.clickSettingsTab();
    }

    @And("I click in delete this account link")
    public void clickInDeleteThisAccountLink() {
        accountDetail.clickDeleteAccountLink();
    }

    @Then("I validate the message is {string}")
    public void iValidateTheMessageIsDisplayed(String expectedMessage) {
        assertEquals(expectedMessage, accountDetail.getAccountMessageDeleted());

    }

    @And("I validate the {string} is not displayed in the Accounts list")
    public void iValidateTheIsNotDisplayedInTheAccountsList(String accountName) {
        assertFalse(accountDetail.isAccountVisible(accountName));
    }

    @And("I go to the Dashboard")
    public void iGoToTheDashboard() {
        header.goToDashboard();
    }

    @And("I validate the {string} account is not displayed in the dropdown")
    public void iValidateTheAccountIsNotDisplayedInTheDropdown(String accountName) {

        assertFalse(projectForm.isAccountVisible(accountName));
        projectForm.clickCancelButton();
    }

    @And("I validate the {string} account is not displayed in the change account dropdown.")
    public void iValidateTheAccountIsNotDisplayedInTheChangeAccountDropdown(String accountName) {
        assertFalse(projectDetails.isAccountVisible(accountName));
    }

    @And("I accept the popup")
    public void iAcceptThePopup() {
        accountDetail.acceptPopup();
    }
}
