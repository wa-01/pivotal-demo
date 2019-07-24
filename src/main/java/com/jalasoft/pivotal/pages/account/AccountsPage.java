package com.jalasoft.pivotal.pages.account;

import com.jalasoft.pivotal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class AccountsPage extends AbstractPage {

    @FindBy(css = "#new_account_link")
    private WebElement createAccountBtn;

    @FindBys({@FindBy(xpath = "//div[contains(@class, 'accounts_list')]/descendant::div[@class='name']")})
    private List<WebElement> listAccountNames;

    public AccountForm clickCreateAccountBtn(){
        action.click(createAccountBtn);
        return new AccountForm();
    }

    // Allows to know if an account Name is listed in the Accounts page
    public boolean listContainsTheAccount(String accountName){
        return listAccountNames.stream()
                .anyMatch(element -> action.getText(element).equals(accountName.toUpperCase()));
    }
}
