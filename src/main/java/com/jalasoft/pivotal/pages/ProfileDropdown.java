package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;

public class ProfileDropdown extends AbstractPage {

    private static final String DROP_DOWN_OPTION = "//a[text()=\"%s\"]";


    public ProfileDropdown() {

    }

    public String getAvatarName() {
        return action.getText(By.cssSelector(".AvatarDetails__name"));
    }

    /**
     *
     * @param option Can be Profile ,Account
     * @return UserManagementHeaderClass
     */
    public UserManagementHeader clickOnDropDownOption(String option) {
        action.click(By.xpath(String.format(DROP_DOWN_OPTION,option)));
        return new UserManagementHeader();
    }

}
