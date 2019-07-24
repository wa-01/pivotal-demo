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

import java.util.Map;

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


    @And("the account {string} is not visible when new project is created")
    public void theAccountIsNotVisibleWhenNewProjectIsCreated(String accountName) {
        header.goToDashboard();
        dashboard.clickCreateProjectButton();
        assertFalse(projectForm.isAccountVisible(accountName));
        projectForm.clickCancelButton();

    }

    @And("the account {string} is not visible on project settings of new project created")
    public void theAccountIsNotVisibleOnProjectSettingsOfNewProjectCreated(String accountName, Map<String, String> data) {
        header.goToDashboard();
        dashboard.clickCreateProjectButton();
        projectForm.createProject(data);
        projectDetails.goToTab("more");
        assertFalse(projectDetails.isAccountVisible(accountName));
    }
}
