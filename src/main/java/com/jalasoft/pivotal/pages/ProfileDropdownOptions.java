package com.jalasoft.pivotal.pages;

import com.jalasoft.pivotal.pages.account.AccountPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileDropdownOptions extends AbstractPage {
    @FindBy(css = "a[href='/accounts']")
    private WebElement accountOption;

    public AccountPage clickAccountOption() {
        action.click(accountOption);
        return new AccountPage();
    }
}
