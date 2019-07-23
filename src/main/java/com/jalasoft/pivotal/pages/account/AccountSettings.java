package com.jalasoft.pivotal.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSettings extends ManageAccount {

    @FindBy(css = "a[data-method='delete']")
    private WebElement deleteThisAccountLink;

    /**
     * Delete action needs to be confirmed by clicking in the ok-cancel alert dialog
     * if actionBtn != 'OK' you can verify in the steps that Delete was not executed.
     * @param actionBtn String that can be OK or CANCEL
     */
    public void clickDeleteAndExecuteWith(String actionBtn) {
        // Since it is possible to cancel the delete action this method doesn't return any object.
        action.click(deleteThisAccountLink);
        action.clickOnAlert(actionBtn);
    }
}
