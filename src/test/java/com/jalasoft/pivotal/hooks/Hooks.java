package com.jalasoft.pivotal.hooks;

import com.jalasoft.pivotal.core.ui.DriverManager;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        DriverManager.getInstance().getDriver().get("https://www.pivotaltracker.com/dashboard");
    }
}
