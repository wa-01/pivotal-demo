package com.jalasoft.pivotal.hooks;

import com.jalasoft.pivotal.core.ui.DriverFactory;
import com.jalasoft.pivotal.core.ui.SharedDriver;
import cucumber.api.java.Before;

public class Hooks {

    public Hooks(final SharedDriver sharedDriver) {

    }

    @Before
    public void setUp() {
        DriverFactory.getDriver().get("https://www.pivotaltracker.com/dashboard");
    }
}
