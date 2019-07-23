package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.core.ui.ISteps;
import com.jalasoft.pivotal.pages.AbstractPage;
import com.jalasoft.pivotal.pages.project.ProjectDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AddAccount extends AbstractPage {
    @FindBy(xpath = "//label[text()='Account Name']/following-sibling::input")
    private WebElement accountName;

    @FindBy(xpath = "//footer[@class='tc-form-modal-footer']/descendant::button[@data-aid='FormModal__submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//footer[@class='tc-form-modal-footer']/descendant::button[@data-aid='FormModal__cancel']")
    private WebElement canceltButton;

    public void setName(String name) {
        action.setValue(accountName, name);
    }

    public DetailsAccount createAccount(String name) {
        this.setName(name);
        action.click(submitButton);
        return new DetailsAccount();
    }
}
