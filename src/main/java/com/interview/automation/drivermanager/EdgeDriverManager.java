package com.interview.automation.drivermanager;

import com.interview.automation.Constants;
import com.interview.automation.capability.CapabilityService;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Map;

public class EdgeDriverManager extends DriverManager{

    private static String KEY_EDGE = "webdriver.edge.driver";

    @Override
    public WebDriver initDriver()  {
        CapabilityService service = CapabilityService.createInstance();
        Map<String, Object> map = service.getCapability();

        System.setProperty(KEY_EDGE, (String) map.get(Constants.CONFIGURATION_DRIVER_PATH));

        MutableCapabilities caps = new MutableCapabilities(map);
        EdgeOptions options = new EdgeOptions();
        options.merge(caps);

        driver = new EdgeDriver(options);
        return driver;
    }


}
