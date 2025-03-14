package com.interview.automation.drivermanager;

import com.interview.automation.Constants;
import com.interview.automation.capability.CapabilityService;
import com.interview.automation.exceptions.DriverInitException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;


public class RemoteDriverManager extends DriverManager {

    @Override
    public WebDriver initDriver() {
        CapabilityService service = CapabilityService.createInstance();
        Map<String, Object> map = service.getCapability();

        MutableCapabilities caps = new MutableCapabilities(map);
        try {
            String url = (String) map.get(Constants.CONFIGURATION_REMOTE_HOST);
            driver = new RemoteWebDriver(new URL(url), caps);
            return driver;
        } catch (MalformedURLException e) {
            throw new DriverInitException("Unable to init RemoteWebDriver.", e.getCause());
        }
    }

}
