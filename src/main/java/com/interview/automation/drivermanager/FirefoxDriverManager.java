package com.interview.automation.drivermanager;

import com.interview.automation.Constants;
import com.interview.automation.capability.CapabilityService;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

public class FirefoxDriverManager extends DriverManager {

    protected static final String KEY_FIREFOX = "webdriver.gecko.driver";

    @Override
    public WebDriver initDriver()  {
        CapabilityService service = CapabilityService.createInstance();
        Map<String, Object> map = service.getCapability();

        System.setProperty(KEY_FIREFOX, (String) map.get(Constants.CONFIGURATION_DRIVER_PATH));

        MutableCapabilities caps = new MutableCapabilities(map);
        FirefoxOptions options = new FirefoxOptions();
        options.merge(caps);

        driver = new FirefoxDriver(options);
        return driver;
    }

}
