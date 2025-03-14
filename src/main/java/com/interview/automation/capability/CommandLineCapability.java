package com.interview.automation.capability;

import com.interview.automation.common.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CommandLineCapability extends Capability {

    @Override
    public Map<String, Object> load() {
        Map<String, Object> map = new HashMap<>();

        // get config from command line arguments
        Properties cliProperties = System.getProperties();
        Set<String> keys2 = cliProperties.stringPropertyNames();
        for (String k : keys2) {
            if (k.startsWith("web.")) { // -Dweb.browser=chrome
                // replace web. with "" -> web.browser -> browser
                // put key and value into map
                map.put(k.replace("web.", ""), Utils.parseVariables(cliProperties.getProperty(k)));
            }
        }
        return map;
    }
}
