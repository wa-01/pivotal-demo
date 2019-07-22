package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.ProfileDropdown;
import com.jalasoft.pivotal.pages.account.AccountModal;
import com.jalasoft.pivotal.pages.account.AccountPage;
import com.jalasoft.pivotal.pages.account.AccountSettingsPage;
import com.jalasoft.pivotal.pages.project.ProjectDetails;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class AccountSteps {

    /*
    private ProjectDetails projectDetails;

    private ProjectForm projectForm;
*/
    private ProfileDropdown profile;
    private AccountPage accountsPage;
    private AccountModal accountModal;
    private AccountSettingsPage accountSettingsPage;
 /*
    public AccountSteps(ProjectDetails projectDetails, ProjectForm projectForm) {
        this.projectDetails = projectDetails;
        this.projectForm = projectForm;
    }
*/
    @And("I click Profiles")
    public void iClickProfile(){
        Header header = new Header();
        profile = header.clickProfileDropdown();
    }

    @And("I click Accounts")
    public void iClickAccountsInProfile(){
        ProfileDropdown profile = new ProfileDropdown();
        accountsPage = profile.clickAccounts();
    }

    @And ("I click Create Account")
    public void iCreateAccount(){
        AccountPage accounts = new AccountPage();
        accountModal = accounts.clickCreateAccount();
    }
    @And ("I create new account {string}")
    public void iSaveNewAccount(String accountName){
        AccountModal accountModal = new AccountModal();
        accountsPage = accountModal.saveNewAccount(accountName);
    }

    @When("I click manageAccount button {string}")
    public void ilistAccount(String accountName){
        AccountPage accounts = new AccountPage();
        accounts.clickAccountsLink();
        accountSettingsPage = accounts.clickManageAccount(accountName);
    }
/*
    @And("I set the project form")
    public void iSetTheProjectForm(Map<String, String> data) {
        projectDetails = projectForm.createProject(data);
    }

    @Then("I validate the Project label is {string}")
    public void iValidateTheProjectLabelIs(String name) {
        String actualProjectName = projectDetails.getProjectNameLabel();
        Assert.assertEquals(actualProjectName, name);
    }

 */
}
