package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.ProfileDropdown;
import com.jalasoft.pivotal.pages.account.AccountModal;
import com.jalasoft.pivotal.pages.account.AccountPage;
import com.jalasoft.pivotal.pages.account.AccountSettingsPage;
import com.jalasoft.pivotal.pages.account.SettingsPane;
import com.jalasoft.pivotal.pages.project.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

import java.io.IOException;
import java.util.Map;

public class AccountSteps {

    private ProfileDropdown profile;
    private AccountPage accountsPage;
    private AccountModal accountModal;
    private AccountSettingsPage accountSettingsPage;
    private SettingsPane settingsPane;
    private ProjectMenu projectMenu;
    private ProjectSettingsForm projectSettingsForm;

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

    @Then ("I validate account {string} was deleted")
    public void iValidateTheAccountWasDeleted(String name) {
        String actualMessage = accountsPage.getAccountDeleteMessage();
        String expectedMessage = name + " was successfully deleted.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @And ("I validate account {string} is not listed")
    public void iValidateTheAccountIsNotListed(String name){
        boolean accountIsListed = true;
        try {
            accountsPage.findAccountInList(name);
        }catch (WebDriverException ex){
            accountIsListed = false;
        }
        Assert.assertFalse(accountIsListed);
    }

    @And ("I validate account {string} is not listed in new project")
    public void iValidateAccountIsNotListedInNewProject(String name){
        boolean accountIsListed = true;
        ProjectForm newProject = settingsPane.createProject();
        try {
            newProject.selectAccount(name);
        }catch (WebDriverException ex){
            accountIsListed = false;
        }
        newProject.cancelCreateProject();
        Assert.assertFalse(accountIsListed);
    }

    @And ("I validate account {string} is not listed in project settings")
    public void iValidateAccountIsNotListedInProjectSettings(String name){
        boolean accountIsListed = true;
        projectMenu = settingsPane.openAnyProject();
        projectSettingsForm = projectMenu.clickMore();
        projectSettingsForm.changeAccountLink();
        try{
            projectSettingsForm.changeAccount(name);
        }catch (WebDriverException ex){
            accountIsListed = false;
        }
        Assert.assertFalse(accountIsListed);
    }
}
