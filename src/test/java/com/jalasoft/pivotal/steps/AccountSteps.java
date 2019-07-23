package com.jalasoft.pivotal.steps;/*
 * @autor: mauricioramirez
 * Project: pivotal-demo
 * Package: com.jalasoft.pivotal.steps
 * Version: 1.0
 */

import com.jalasoft.pivotal.pages.accounts.AccountsPage;
import com.jalasoft.pivotal.pages.accounts.ManageAccountPage;
import com.jalasoft.pivotal.pages.accounts.NewAccountForm;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.Map;

public class AccountSteps {

    private AccountsPage accountsPage = new AccountsPage();

    @Given("I create a new Account with name {string}")
    public void iCreateANewAccountWithName(String account_name) {
        Map<String, String> data = new HashMap<>();
        data.put("account_name", account_name);

        NewAccountForm newAccountForm = accountsPage.clickNewAccountButton();
        newAccountForm.setFormfields(data);

        ManageAccountPage manageAccountPage = newAccountForm.clickSubmitButton();
    }

    @When("I click on {string} button for account {string}")
    public void iClickOnButtonForAccount(String buttonName, String accountName) {
        ManageAccountPage manageAccountPage = accountsPage.clickManageAccountButton(accountName);
    }
}
