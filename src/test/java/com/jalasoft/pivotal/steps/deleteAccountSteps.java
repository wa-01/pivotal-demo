package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.core.Environment;
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

public class deleteAccountSteps {
    private Signin signin;
    private String user = "owner";
    private String accountName = "My Account";
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

    public deleteAccountSteps(Signin signin) {
        this.signin = signin;
        init();
    }

    private void init(){
        dashboard = new Dashboard();
        projectForm = new ProjectForm();
        projectData = new HashMap<>();
        projectData.put("name", projectName);
        projectData.put("account", projectAccount);
        projectData.put("privacy", projectPrivacy);
        header = new Header();
        settings = new AccountSettings();
    }

    @Given("I login")
    public void iLogin() {
        String userName = Environment.getInstance().getValue(String.format("$['credentials']['%s']['username']", user));
        String password = Environment.getInstance().getValue(String.format("$['credentials']['%s']['password']", user));
        signin.loginAs(userName, password);
    }

    @And("I have a project created")
    public void iHaveAProjectCreated() {
        dashboard.clickCreateProjectButton();
        projectDetails = projectForm.createProject(projectData);
    }

    @And("I have an account created")
    public void iHaveAnAccountCreated() {
        projectDetails.isProjectPageLoaded();
        profileDropdown = header.clickProfileDropdown();
        accounts = profileDropdown.clickAccountOption();

        accountForm = accounts.clickCreateButton();
        account = accountForm.createAccount(accountName);
        account.isAccountPageLoaded();
    }

    @When("I open the account settings")
    public void iOpenTheAccountSettings() {
        profileDropdown = header.clickProfileDropdown();
        accounts = profileDropdown.clickAccountOption();
        accounts.clickManageAccount(accountName);
        account.clickTabMenu("Settings");
    }

    @And("I delete the account")
    public void iDeleteTheAccount() {
        settings.deleteAccount();
    }

    @Then("I see the confirmation message")
    public void iSeeTheConfirmationMessage() {
        String expectedMessage = accountName + " was successfully deleted.";
        String actualMessage = accounts.getDeletedMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @But("I don't see the account in the accounts menu")
    public void iDonTSeeTheAccountInTheAccountsMenu() {
        Assert.assertFalse(accounts.accountExists(accountName));
    }

    @But("I don't see the account in the create project form")
    public void iDonTSeeTheAccountInTheCreateProjectForm() {
        dashboard = header.goToDashboard();
        projectForm = dashboard.clickCreateProjectButton();
        projectForm.clickSelectAccount();
        Assert.assertFalse(projectForm.isAccountVisible(accountName));
    }

    @But("I don't see the account in project settings")
    public void iDonTSeeTheAccountInProjectSettings() {
        projectForm.clickCancelButton();
        dashboard.clickProjectLink();
        projectDetails.isProjectPageLoaded();
        more= projectDetails.clickMoreMenu();
        more.clickChangeAccount();
        Assert.assertFalse(more.accountIsPresent(accountName));
    }

}
