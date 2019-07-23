package com.jalasoft.pivotal.steps;

import com.jalasoft.pivotal.pages.AccountPage;
import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.ProfileDropdown;
import cucumber.api.java.en.And;

import java.util.Map;



public class AccountSteps {

    private ProfileDropdown profileDropdown;
    private Header header;
    private AccountPage accountPage;

    public AccountSteps(ProfileDropdown profileDropdown, Header header, AccountPage accountPage){
        this.profileDropdown = profileDropdown;
        this.header=header;
        this.accountPage = accountPage;
    }

    @And("I create an account with :")
    public void iCreateAnAccountWith(Map<String, String> data) {
        profileDropdown=header.clickProfileDropdown();
        AccountPage accountPage=profileDropdown.goToAccountPage();
        accountPage.createAccount(data);
    }
}
