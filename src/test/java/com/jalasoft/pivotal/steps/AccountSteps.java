package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.*;
import com.jalasoft.pivotal.pages.project.ProjectDetails;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import com.jalasoft.pivotal.pages.project.ProjectSettings;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class AccountSteps {

    private ProfileDropdown profileDropdown;
    private Header header;
    private AccountPage accountPage;
    private ManageSpecificAccountPage manageSpecificAccountPage;
    private Dashboard dashboard;
    private ProjectForm projectForm;
    private ProjectSettings projectSettings;
    private ProjectDetails projectDetails;
    private String accountID;

    public AccountSteps(ProfileDropdown profileDropdown, Header header, AccountPage accountPage, ManageSpecificAccountPage manageSpecificAccountPage, Dashboard dashboard, ProjectForm projectForm ,ProjectSettings projectSettings,ProjectDetails projectDetails){
        this.profileDropdown = profileDropdown;
        this.header=header;
        this.accountPage = accountPage;
        this.manageSpecificAccountPage = manageSpecificAccountPage;
        this.dashboard = dashboard;
        this.projectForm = projectForm;
        this.projectSettings=projectSettings;
        this.projectDetails=projectDetails;
    }

    @And("I create an account with :")
    public void iCreateAnAccountWith(Map<String, String> data) {
        profileDropdown=header.clickProfileDropdown();
        accountPage=profileDropdown.goToAccountPage();
        manageSpecificAccountPage= accountPage.createAccount(data);
    }

    @And("I capture accountID")
    public void iCaptureAccountID() {
        this.accountID=manageSpecificAccountPage.getAccountID();
        System.out.println(accountID);
    }

    @And("In ManageAccountPage select the tab {string}")
    public void iSelectTheTab(String option)
    {
        manageSpecificAccountPage.selectManageAccountTab(option);
    }

    @And("I create project from account manage page with {string}")
    public void iCreateProjectFromManageAccountPage(String projectName) {
        projectForm=manageSpecificAccountPage.clickOnCreateProjectLink();
        projectDetails=projectForm.createProject(projectName);
    }

    @When("I go to accounts page")
    public void iGoToAccountsPage() {
        dashboard=projectDetails.goToHome();
        profileDropdown=header.clickProfileDropdown();
        accountPage=profileDropdown.goToAccountPage();
    }

    @And("I click on delete account")
    public void iClickOnDeleteAccount() {
        accountPage=manageSpecificAccountPage.deleteAccount();
    }

    @Then("I validate that the message {string} is displayed")
    public void iValidateTheDeletedMessageIsDisplayed(String notificationMessage) {
        assertTrue(accountPage.IsDeleteNotificationDisplayed(notificationMessage));
    }

    @Then("I validate the account with accountID is not present in account list")
    public void iValidateTheAccountWithNameIsNotPresentInAccountList() {
        assertFalse(accountPage.isAccountListed(accountID));

    }

    @When("I go to manage account page according to accountID")
    public void iGoToManageAccountSettings() {
        manageSpecificAccountPage=accountPage.goToAccountSpecificSettings(accountID);
    }

    @And("I validate that account with name {string} is not in project form")
    public void iValidateThatAccountWithNameIsNotInProjectForm(String accountName) {
       dashboard= header.goToDashboard();
       projectForm=dashboard.clickCreateProjectButton();
       assertFalse( projectForm.isAccountInAccountSelect(accountName));
       projectForm.closeProjectForm();
    }

    @And("I validate that account with accountID is not present in project settings {string}")
    public void iValidateThatAccountWithAccountIDIsNotPresentInProjectSettings(String projectName) {
        projectSettings=dashboard.goToSpecificProjectSettings(projectName);
        projectSettings.isThisAccountInAccountSelectorOptions(accountID);
        assertFalse(projectSettings.isThisAccountInAccountSelectorOptions(accountID));
    }
}
