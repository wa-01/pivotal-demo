package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalContent extends AbstractPage {

    @FindBy(css = "input[data-aid='input']")
    private WebElement accountNameTextField;

    @FindBy(css = "button[data-aid='FormModal__submit']")
    private WebElement createButton;

    public void setAccountNameTextField(String accountName){
        action.setValue(accountNameTextField, accountName);
    }

    public ManageAccount clickCreateButton(){
        action.click(createButton);
        return new ManageAccount();
    }
}
