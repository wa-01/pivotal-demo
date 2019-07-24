package com.jalasoft.pivotal.steps;/*
 * @autor: mauricioramirez
 * Project: pivotal-demo
 * Package: com.jalasoft.pivotal.steps
 * Version: 1.0
 */

import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.accounts.AccountsPage;
import com.jalasoft.pivotal.pages.accounts.ManageAccountPage;
import com.jalasoft.pivotal.pages.accounts.NewAccountForm;
import com.jalasoft.pivotal.pages.project.ProjectForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.Map;

public class AccountSteps {

    private AccountsPage accountsPage = new AccountsPage();
    private Header headerPage = new Header();

    @Given("I create a new Account with name {string}")
    public void iCreateANewAccountWithName(String account_name) {

        headerPage.clickProfileDropdown().clickAccountsLink();

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

    @Then("I validate the account {string} is deleted on Accounts Page")
    public void iValidateTheAccountIsDeletedOnAccountsPage(String accountName) {
        try {
            accountsPage.getAccountCardTitle(accountName);

            assert false;
        }
        catch (Exception e) {
            assert true;
        }
    }

    @Then("I validate a notice message is displayed with the message {string}")
    public void iValidateANoticeMessageIsDisplayedWithTheMessage(String accountName) {
        String message = accountsPage.getFlashNoticeMessage();

        assert message.contains(accountName);
    }

    @Then("I validate {string} is not present on create project form")
    public void iValidateIsNotPresentOnCreateProjectForm(String accountName) {
        accountsPage.goToPage("dashboard");

        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        try {
            projectForm.selectAccount(accountName);

            assert false;
        }
        catch (Exception e) {
            assert true;
        }

    }
}
