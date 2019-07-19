package com.jalasoft.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Signin extends AbstractPage {

    @FindBy(css = "#credentials_username")
    private WebElement userNameTextField;

    @FindBy(css = "#credentials_password")
    private WebElement passwordTextField;

    @FindBy(css = ".app_signin_action_button")
    private WebElement loginButton;

    public Header loginAs(String userName, String password) {
        driver.get("https://www.pivotaltracker.com/signin?source=navbar");
        action.setValue(userNameTextField, userName);
        action.click(loginButton);
        action.setValue(passwordTextField, password);
        action.click(loginButton);
        return new Header();
    }
}
