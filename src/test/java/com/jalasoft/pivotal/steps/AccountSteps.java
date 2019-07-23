package com.jalasoft.pivotal.steps;

import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import com.jalasoft.pivotal.pages.Account;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import org.testng.Assert;

public class AccountSteps {

    private Account account;

    public AccountSteps(Account account) {
        this.account = account;
    }

    @And("I Create an Account {string}")
    public void createAccount (String accountName){
        this.iClickUserMenu();
        this.iClickAccountOption();
        this.iClickCreateAccountButton();
        this.iCreateAnAccount(accountName);
        this.iClickCreate();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I Delete the Account {string}")
    public void deleteAccount(String accountName){
        this.iClickSettings();
        this.iClickLinkDeleteThisAccount();
    }

    @And("I click Profile dropdown")
    public void iClickUserMenu() {
        account.clickUserMenu();
    }

    @And("I click Account option")
    public void iClickAccountOption(){
        account.clickAccountOption();
    }

    @And("I click Create Account button")
    public void iClickCreateAccountButton(){
        account.clickCreateAccount();
    }

    @And("I Create an Account")
    public void iCreateAnAccount(String name){
        account.createAnAccount(name);
    }

    @And("I Click Create Account button")
    public void iClickCreate() {
        account.clickCreate();
    }

    @And("I Click tab Settings")
    public void iClickSettings() {
        account.clickSettings();
    }

    @And("I Click link Delete this account")
    public void iClickLinkDeleteThisAccount(){
        account.clickLinkDelete();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.acceptPopup();
    }

    @And ("I Click Manage Account for {string}")
    public void iClickManageAccount(String accountName){
        account.clickManageAccount(accountName);
    }

    @Then("I validate {string} account was successfully deleted message is displayed")
    public void IValidateDeletedMessage(String accountName){
        String message = account.getDeleteConfirmationMessage();
        String compare = accountName + " was successfully deleted.";
        Assert.assertEquals(compare, message );
    }

    @Then ("I validate {string} account is not displayed in Accounts menu")
    public void IValidateAccountDeletedFromMenu(String accountName){
        Assert.assertFalse(account.existAccount(accountName));
    }
}
