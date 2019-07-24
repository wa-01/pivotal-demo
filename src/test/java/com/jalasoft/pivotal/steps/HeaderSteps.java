package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.ProfileDropdown;
import com.jalasoft.pivotal.pages.account.Account;
import cucumber.api.java.en.When;

public class HeaderSteps {

    private Header header;
    private ProfileDropdown profileDropdown;
    private Account account;


    public HeaderSteps(Header header, ProfileDropdown profileDropdown, Account account) {
        this.header = header;
        this.profileDropdown = profileDropdown;
        this.account = account;
    }

    @When("I click profile dropdown button")
    public void iClickProfileDropdownButton() {
        ProfileDropdown profileDropdown = header.clickProfileDropdown();
    }

    @When("I go to accounts")
    public void iGoToAccounts() {
        ProfileDropdown profileDropdown = header.clickProfileDropdown();
        profileDropdown.clickAccounts();
        account.getNewAccountLink();
    }

    @When("I go to dashboard")
    public void iGoToDashboard() {
        header.goToDashboard();
    }
}
