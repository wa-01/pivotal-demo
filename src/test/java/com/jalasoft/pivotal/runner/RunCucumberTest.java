package com.jalasoft.pivotal.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

/**
 * Class which runs all features.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.jalasoft.pivotal"},
        plugin = {"pretty"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    /**
     * this method execute before the tests.
     */
    @BeforeTest
    public void open() {
        // Implement.
        System.setProperty("dataproviderthreadcount", "5");
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    /**
     * this method close the browser after the features finish.
     */
    @AfterTest
    public void close() {
        // Implement.
    }
}
