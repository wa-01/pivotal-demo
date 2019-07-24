package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.account.AccountSettingsPage;
import com.jalasoft.pivotal.pages.account.AccountPage;
import com.jalasoft.pivotal.pages.project.ProjectDetails;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class AccountSteps {
    private AccountPage account;
    private AccountSettingsPage accountSettingsPage;
    private Dashboard dashboard;
    private ProjectForm projectForm;
    private Header header;
    private ProjectDetails projectDetails;

    public AccountSteps(AccountPage account, AccountSettingsPage accountSettingsPage, Dashboard dashboard,
                        ProjectForm projectForm, Header header, ProjectDetails projectDetails) {
        this.account = account;
        this.accountSettingsPage = accountSettingsPage;
        this.dashboard = dashboard;
        this.projectForm = projectForm;
        this.header = header;
        this.projectDetails = projectDetails;
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

    @And("account {string} is not present in the Accounts list")
    public void accountIsNotPresentInTheAccountsList(String accName) {
        assertFalse(accountSettingsPage.isAccountNamePresent(accName));

    }

    @And("account {string} is not listed on create project dropdown")
    public void accountIsNotListedOnCreateProjectDropdown(String accName) {
//        dashboard.clickCreateProjectButton();
        assertFalse(projectForm.findAccount(accName));
    }

    @And("I go to the Dashboard")
    public void iGoToTheDashboard() {
        projectForm.cancelProject();
    }

    @And("I click the more tab in projects page")
    public void iClickTheTabInProjectsPage() {
        projectDetails.goToTab("more");
    }

    @And("account {string} is not displayed on the project dropdown settings.")
    public void accountIsNotDisplayedOnTheProjectDropdownSettings(String accName) {
        assertFalse(projectDetails.isAccountDisplayed(accName));
    }

    @And("I open the Dashboard")
    public void iOpenTheDashboard() {
        header.goToDashboard();
    }
}
