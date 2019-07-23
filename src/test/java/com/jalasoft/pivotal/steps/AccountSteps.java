package com.jalasoft.pivotal.steps;


import com.jalasoft.pivotal.pages.account.Account;
import com.jalasoft.pivotal.pages.account.ManageAccount;
import com.jalasoft.pivotal.pages.account.ModalContent;
import cucumber.api.java.en.When;

import static org.testng.Assert.*;

public class AccountSteps {

    private Account account;
    private ModalContent modalContent;
    private ManageAccount manageAccount;


    public AccountSteps(Account account,ModalContent modalContent, ManageAccount manageAccount) {
        this.account = account;
        this.modalContent = modalContent;
        this.manageAccount = manageAccount;
    }

    @When("I create account {string}")
    public void iCreateAccount(String accountName) {
        modalContent = account.clickNewAccountLink();
        modalContent.setAccountNameTextField(accountName);
        manageAccount = modalContent.clickCreateButton();
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
        assertEquals(notice, account.getNoticeBanner());
    }

    @When("I validate account {string} is not displayed")
    public void iValidateAccountNotDisplayed(String accountName) {
        assertFalse(account.findAccountOwnName(accountName));
    }
}
