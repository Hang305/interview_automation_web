package com.interview.automation.test;

import com.interview.automation.Constants;
import com.interview.automation.common.Helper;
import com.interview.automation.drivermanager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    private WebDriver driver;
    private Helper waitHelper;
    @BeforeTest(alwaysRun = true)
    public void setup() {
        driver = DriverFactory.getDriver();
        waitHelper = new Helper(driver, Constants.MEDIUM_TIME);
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
