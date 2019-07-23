package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.ProfileDropdown;
import com.jalasoft.pivotal.pages.account.AccountModal;
import com.jalasoft.pivotal.pages.account.AccountPage;
import com.jalasoft.pivotal.pages.account.AccountSettingsPage;
import com.jalasoft.pivotal.pages.account.SettingsPane;
import com.jalasoft.pivotal.pages.project.ProjectDetails;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class AccountSteps {

    private ProfileDropdown profile;
    private AccountPage accountsPage;
    private AccountModal accountModal;
    private AccountSettingsPage accountSettingsPage;
    private SettingsPane settingsPane;

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
    public void iListAccount(String accountName){
        AccountPage accounts = new AccountPage();
        accounts.clickAccountsLink();
        accountSettingsPage = accounts.clickManageAccount(accountName);
    }

    @And ("I click Setting")
    public void iClickSettings(){
        AccountSettingsPage accountSettings = new AccountSettingsPage();
        settingsPane = accountSettings.clickSettings();
    }

    @And ("I click Delete link")
    public void iClickDeleteAccountLink(){
        SettingsPane settingsPane = new SettingsPane();
        accountSettingsPage = settingsPane.deleteAccount();
    }

    @Then("I validate the account {string} was deleted")
    public void iValidateTheAccountWasDeleted(String name) {
        String actualMessage = accountsPage.getAccountDeleteMessage();
        String expectedMessage = name + " was successfully deleted.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
