package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Account.Account;
import com.jalasoft.pivotal.pages.Account.AccountSettings;
import com.jalasoft.pivotal.pages.Account.CreateNewAccountForm;
import com.jalasoft.pivotal.pages.Account.UserAccounts;
import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.ProfileDropdown;
import com.jalasoft.pivotal.pages.project.MorePage;
import com.jalasoft.pivotal.pages.project.ProjectDetails;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class deleteAccountSteps {
    private ProfileDropdown profileDropdown;
    UserAccounts accounts;
    Header header;
    Dashboard dashboard;
    ProjectForm projectForm;
    Account account;
    ProjectDetails details;

    @Given("I go to Accounts")//"I click Profile dropdown list")
    public void iGoToAccounts() {
        header = new Header();
        details = new ProjectDetails();
        details.isProjectPageLoaded();
        profileDropdown = header.clickProfileDropdown();
        accounts = profileDropdown.clickAccountOption();
    }
/*
    @And("I click Accounts")
    public void iClickAccounts() {
        accounts = profileDropdown.clickAccountOption();
    }*/

    @And("I create an account with name {string}")
    public void iCreateAnAccountWithName(String accountName) {
        CreateNewAccountForm accountForm = accounts.clickCreateButton();
        account = accountForm.createAccount(accountName);
    }

    @And("I click {string} tab")
    public void iClickTab(String tabMenu) {
        account.clickTabMenu(tabMenu);
    }

    @And("I click delete this account")
    public void iClickDeleteThisAccount() {
        AccountSettings settings = new AccountSettings();
        settings.deleteAccount();
    }

    @Then("I validate the {string} is displayed in deleted account message")
    public void iValidateTheIsDisplayedInDeletedAccountMessage(String accountName) {
        String expectedMessage = accountName + " was successfully deleted.";
        String actualMessage = accounts.getDeletedMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @And("I validate the {string} is no longer visible from accounts menu")
    public void iValidateTheIsNoLongerVisibleFromAccountsMenu(String accountName) {
        Assert.assertFalse(accounts.accountExists(accountName));
    }

    @And("I validate the {string} is not visible from create project form")
    public void iValidateTheIsNotVisibleFromCreateProjectForm(String accountName) {
        dashboard = header.goToDashboard();
        projectForm = dashboard.clickCreateProjectButton();
        projectForm.clickSelectAccount();
        Assert.assertFalse(projectForm.isAccountVisible(accountName));
    }

    @And("I validate that the account {string} is not visible changing account from project page")
    public void iValidateThatTheAccountIsNotVisibleChangingAccountFromProjectPage(String accountName) {
        projectForm.clickCancelButton();
        dashboard.clickProjectLink();
        details.isProjectPageLoaded();
        MorePage more= details.clickMoreMenu();
        more.clickChangeAccount();
        Assert.assertFalse(more.accountIsPresent(accountName));
    }

    @And("I click manage account button in account {string}")
    public void iClickManageAccountButtonInAccount(String accountName) {
        accounts.clickManageAccount(accountName);
    }
}
