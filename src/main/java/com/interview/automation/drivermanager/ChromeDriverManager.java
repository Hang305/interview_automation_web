package com.interview.automation.drivermanager;

import com.interview.automation.Constants;
import com.interview.automation.capability.CapabilityService;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class ChromeDriverManager extends DriverManager {

    protected static String KEY_CHROME = "webdriver.chrome.driver";

    @Override
    public WebDriver initDriver()  {
        CapabilityService service = CapabilityService.createInstance();
        Map<String, Object> map = service.getCapability();

        System.setProperty(KEY_CHROME, (String) map.get(Constants.CONFIGURATION_DRIVER_PATH));

        MutableCapabilities caps = new MutableCapabilities(map);
        ChromeOptions options = new ChromeOptions();
        options.merge(caps);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--incognito");
        return driver;
    }

}
