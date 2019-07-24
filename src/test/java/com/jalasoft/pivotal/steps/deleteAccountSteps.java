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
    private String projectName = "My Project Eval";
    private String projectAccount = "account1";
    private String projectPrivacy = "public";
    private ProfileDropdown profileDropdown;
    private UserAccounts accounts;
    private Header header;
    private Dashboard dashboard;
    private ProjectForm projectForm;
    private Account account;
    private ProjectDetails projectDetails;
    private CreateNewAccountForm accountForm;
    private Map<String,String> projectData;
    private  MorePage more;
    private AccountSettings settings;

    public deleteAccountSteps() {
        init();
    }

    private void init(){
        dashboard = new Dashboard();
        projectForm = new ProjectForm();
        projectData = new HashMap<>();
        projectData.put("name", projectName);
        projectData.put("account", projectAccount);
        projectData.put("privacy", projectPrivacy);
        projectDetails = new ProjectDetails();
        header = new Header();
        settings = new AccountSettings();
    }

    @And("I have an account created {string}")
    public void iHaveAnAccountCreated(String accountName) {
        projectDetails.isProjectPageLoaded();
        profileDropdown = header.clickProfileDropdown();
        accounts = profileDropdown.clickAccountOption();

        accountForm = accounts.clickCreateButton();
        account = accountForm.createAccount(accountName);
        account.isAccountPageLoaded();
    }

    @When("I open the account settings for {string}")
    public void iOpenTheAccountSettingsFor(String accountName) {
        profileDropdown = header.clickProfileDropdown();
        accounts = profileDropdown.clickAccountOption();
        accounts.clickManageAccount(accountName);
        account.clickTabMenu("Settings");
    }

    @And("I delete the account")
    public void iDeleteTheAccount() {
        settings.deleteAccount();
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

    @But("I don't see the account {string} in the create project form")
    public void iDonTSeeTheAccountInTheCreateProjectForm(String accountName) {
        dashboard = header.goToDashboard();
        projectForm = dashboard.clickCreateProjectButton();
        projectForm.clickSelectAccount();
        Assert.assertFalse(projectForm.isAccountVisible(accountName));
    }

    @But("I don't see the account {string} in project settings")
    public void iDonTSeeTheAccountInProjectSettings(String accountName) {
        projectForm.clickCancelButton();
        dashboard.clickProjectLink();
        projectDetails.isProjectPageLoaded();
        more= projectDetails.clickMoreMenu();
        more.clickChangeAccount();
        Assert.assertFalse(more.accountIsPresent(accountName));
    }
}
