package com.interview.automation.page;

import com.interview.automation.drivermanager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseWebPage {

    protected WebDriver driver;

    public BaseWebPage() {
        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void close() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
