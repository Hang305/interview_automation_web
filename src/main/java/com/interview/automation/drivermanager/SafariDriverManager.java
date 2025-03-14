package com.interview.automation.drivermanager;

import com.interview.automation.capability.CapabilityService;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.Map;

public class SafariDriverManager extends DriverManager {


    @Override
    public WebDriver initDriver()  {
        CapabilityService service = CapabilityService.createInstance();
        Map<String, Object> map = service.getCapability();

        MutableCapabilities caps = new MutableCapabilities(map);
        SafariOptions options = new SafariOptions();
        options.merge(caps);

        driver = new SafariDriver(options);
        return driver;
    }

}
