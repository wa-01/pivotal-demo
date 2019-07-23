package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Accounts;
import com.jalasoft.pivotal.pages.Header;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class AccountSteps {

    private Header header;
    private Accounts accounts;

    public AccountSteps(Header header, Accounts accounts){
        this.header = header;
        this.accounts = accounts;
    }

    @And("I click the profile dropdown")
    public void iClickTheProfileDropdown() {
        header.clickProfileDropdown();
    }

    @And("I select Accounts")
    public void iClickTheAccountsOption(){
        header.clickDropdownAccounts();
    }

    @And("I click the Create Account button")
    public void iClickTheCreateAccountButton(){
        accounts.clickCreateAccount();
    }

    @And("I create the Account name:")
    public void iSetAccountName(Map<String, String> data){
        accounts.setAccountName(data);
    }

    @And("I go to the Accounts page")
    public void iClickAccountsTab(){
        accounts.clickAccountsTab();
    }

    @When("I click {string} manage account button")
    public void iClickManageAccountButton(String accountName){
        accounts.clickManageAccountButton(accountName);
    }

    @And("I click the settings tab")
    public void iClickSettingsTab(){
        accounts.clickSettingsTab();
    }

    @And("I click delete this account")
    public void iClickDeleteAccount(){
        accounts.clickDeleteAccount();
    }

    @And("I accept delete alert")
    public void iAcceptDeleteAccount(){
        accounts.acceptDeleteAlert();
    }

    @And("I validate {string} account is deleted")
    public void iValidateAccountIsDeleted(String accountName) {
        assertNotEquals(accountName, accounts.getAccountName(accountName));
    }

}
