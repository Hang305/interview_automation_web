package com.interview.automation.capability;

import java.util.HashMap;
import java.util.Map;

// design pattern: singleton
public class CapabilityService {

    private static CapabilityService service;

    private CapabilityService() {

    }

    public static CapabilityService createInstance() {
        if (service == null)
            service = new CapabilityService();
        return service;
    }

    private Map<String, Object> runtimeMap = new HashMap<>();

    // config: file, command
    public Map<String, Object> getCapability() {

        Map<String, Object> map = new HashMap<>();

        Capability fileCapability = new FileCapability();
        Map<String, Object> fCapabilities = fileCapability.load();

        Capability capability = new CommandLineCapability();
        Map<String, Object> cliCapabilities = capability.load();

        // add các config từ file và command line vào map
        map.putAll(fCapabilities);
        map.putAll(cliCapabilities);
        map.putAll(runtimeMap);

        return map;
    }

    public void setCapability(String key, Object value) {
        runtimeMap.put(key, value);
    }
}
