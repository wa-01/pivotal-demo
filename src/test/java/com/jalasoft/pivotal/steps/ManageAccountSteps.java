package com.jalasoft.pivotal.steps;/*
 * @autor: mauricioramirez
 * Project: pivotal-demo
 * Package: com.jalasoft.pivotal.steps
 * Version: 1.0
 */

import com.jalasoft.pivotal.pages.accounts.ManageAccountPage;
import cucumber.api.java.en.When;

public class ManageAccountSteps {

    private ManageAccountPage manageAccountPage = new ManageAccountPage();

    @When("I click on {string} navbar button")
    public void iClickOnNavbaButton(String buttonName) {
        manageAccountPage.clickSettingsButton();
    }

    @When("I click on {string} link")
    public void iClickOnDeleteAccountButton(String linkName) {
        manageAccountPage.deleteAccount();
    }

}
