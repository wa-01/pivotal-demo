package com.jalasoft.pivotal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NoticeBanner extends AbstractPage{
    // A notice banner is displayed when an account or project were deleted

    @FindBy(css = "#notice")
    private WebElement noticeBanner;

    public String getNoticeText(){
        return action.getText(noticeBanner);
    }
}
