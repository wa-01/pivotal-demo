package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Account.Account;
import com.jalasoft.pivotal.pages.Account.AccountSettings;
import com.jalasoft.pivotal.pages.Account.CreateNewAccountForm;
import com.jalasoft.pivotal.pages.Account.UserAccounts;
import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.ProfileDropdown;
import com.jalasoft.pivotal.pages.Signin;
import com.jalasoft.pivotal.pages.project.MorePage;
import com.jalasoft.pivotal.pages.project.ProjectDetails;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import cucumber.api.java.en.*;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class deleteAccountSteps {
    private ProfileDropdown profileDropdown;
    private UserAccounts accounts;
    private Header header;
    private Dashboard dashboard;
    private ProjectForm projectForm;
    private Account account;
    private ProjectDetails projectDetails;
    private CreateNewAccountForm accountForm;
    private MorePage more;
    private AccountSettings settings;

    public deleteAccountSteps(Dashboard dashboard, ProjectForm projectForm, ProjectDetails projectDetails, Header header, AccountSettings settings) {
        this.dashboard = dashboard;
        this.projectForm = projectForm;
        this.projectDetails = projectDetails;
        this.header = header;
        this.settings = settings;
    }

    @And("I go to Accounts menu")
    public void iGoToAccountsMenu() {
        profileDropdown = header.clickProfileDropdown();
        accounts = profileDropdown.clickAccountOption();
    }

    @And("I click create account button")
    public void iClickCreateAccountButton() {
        accountForm = accounts.clickCreateButton();
    }

    @And("I create the account with name {string}")
    public void iCreateTheAccountWithName(String accountName) {
        account = accountForm.createAccount(accountName);
        account.isAccountPageLoaded();
    }

    @And("I open the account {string}")
    public void iOpenTheAccount(String accountName) {
        accounts.clickManageAccount(accountName);
    }

    @And("I go to {string} tab")
    public void iGoToTab(String tabName) {
        account.clickTabMenu(tabName);
    }

    @And("I delete the account")
    public void iDeleteTheAccount() {
        settings.deleteAccount();
        accounts.isAccountsPageLoaded();
    }

    @Then("I see the confirmation message with the account {string}")
    public void iSeeTheConfirmationMessageWithTheAccount(String accountName) {
        String expectedMessage = accountName + " was successfully deleted.";
        String actualMessage = accounts.getDeletedMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @But("I don't see the account {string} in the accounts menu")
    public void iDonTSeeTheAccountInTheAccountsMenu(String accountName) {
        Assert.assertFalse(accounts.accountExists(accountName));
    }

    @And("I go to dashboard")
    public void iGoToDashboard() {
        dashboard = header.goToDashboard();
    }

    @And("I expand account droplist")
    public void iExpandAccountDroplist() {
        projectForm.clickSelectAccount();
    }

    @But("I don't see the account {string} in the create project form")
    public void iDonTSeeTheAccountInTheCreateProjectForm(String accountName) {
        Assert.assertFalse(projectForm.isAccountVisible(accountName));
        projectForm.clickCancelButton();
    }

    @And("I open the project {string}")
    public void iOpenTheProject(String projectName) {
        dashboard.clickProjectLink(projectName);
        projectDetails.isProjectPageLoaded();
    }

    @And("I click {string} tab menu")
    public void iClickMoreOption(String tabMenu) {
        more = projectDetails.goToTab(tabMenu);
    }

    @But("I don't see the account {string} in project settings")
    public void iDonTSeeTheAccountInProjectSettings(String accountName) {
        more.clickChangeAccount();
        Assert.assertFalse(more.accountIsPresent(accountName));
    }

}
