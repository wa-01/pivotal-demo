package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.core.ui.ISteps;
import com.jalasoft.pivotal.pages.project.ProjectDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Accounts extends AbstractPage{

    @FindBy(css = ".create_account_button")
    private WebElement createAccountButton;

    @FindBy(css = "input[data-aid='input']")
    private WebElement accountNameTextInput;

    public void clickCreateAccount(){
        action.click(createAccountButton);
    }





}
