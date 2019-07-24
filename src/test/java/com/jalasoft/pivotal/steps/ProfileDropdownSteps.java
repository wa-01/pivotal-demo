package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.ProfileDropdown;

import com.jalasoft.pivotal.pages.account.Account;
import cucumber.api.java.en.When;

public class ProfileDropdownSteps {

    private ProfileDropdown profileDropdown;
    private Account account;

    public ProfileDropdownSteps(ProfileDropdown profileDropdown, Account account) {
        this.profileDropdown = profileDropdown;
        this.account = account;
    }

    @When("I navigate to accounts")
    public void clickAccounts() {
        Account account = profileDropdown.clickAccounts();
    }
}
