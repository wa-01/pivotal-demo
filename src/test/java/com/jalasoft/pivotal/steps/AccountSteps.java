package com.jalasoft.pivotal.steps;


import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.account.Account;
import com.jalasoft.pivotal.pages.account.ManageAccount;
import com.jalasoft.pivotal.pages.account.ModalContent;
import com.jalasoft.pivotal.pages.project.ProjectSettings;
import cucumber.api.java.en.When;

import static org.testng.Assert.*;

public class AccountSteps {

    private Account account;
    private ModalContent modalContent;
    private ManageAccount manageAccount;
    private Dashboard dashboard;
    private ProjectSettings projectSettings;

    public AccountSteps(Account account,ModalContent modalContent, ManageAccount manageAccount, Dashboard dashboard, ProjectSettings projectSettings) {
        this.account = account;
        this.modalContent = modalContent;
        this.manageAccount = manageAccount;
        this.dashboard = dashboard;
        this.projectSettings = projectSettings;
    }

    @When("I create account {string}")
    public void iCreateAccount(String accountName) {
        modalContent = account.clickNewAccountLink();
        modalContent.setAccountNameTextField(accountName);
        manageAccount = modalContent.clickCreateButton();
        manageAccount.isAccountCreated(accountName);
    }

    @When("I manage account {string}")
    public void iManageAccount(String accountName) {
        manageAccount = account.clickManageAccount(accountName);
    }

    @When("I click {string} accounts tab")
    public void iClickManageAccountTab(String accountTabName) {
        manageAccount.clickManageAccountTab(accountTabName);
    }

    @When("I click delete this account")
    public void iClickDeleteThisAccount() {
        manageAccount.clickDeleteThisAccountLink();
    }

    @When("I validate notice {string} is displayed")
    public void iValidateNotice(String notice) {
        assertEquals(account.getNoticeBanner(), notice);
    }

    @When("I validate account {string} is not displayed")
    public void iValidateAccountNotDisplayed(String accountName) {
        assertFalse(account.findAccountOwnName(accountName));
    }

    @When("I delete this account and notice {string} is displayed")
    public void iDeleteThisAccountAndValidateNotice(String notice) {
        iClickManageAccountTab("Settings");
        iClickDeleteThisAccount();
        iValidateNotice(notice);
    }

    @When("I validate account {string} is not displayed in project {string} settings")
    public void iValidateAccountNotDisplayedProjectSettings(String expectedAccountName, String projectName) {
        dashboard.clickProjectSettings(projectName);
        assertFalse(projectSettings.isProjectAccountAvailable(expectedAccountName));

    }
}
