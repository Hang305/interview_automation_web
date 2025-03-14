package com.interview.automation.capability;

import com.interview.automation.Constants;
import com.interview.automation.common.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class FileCapability extends Capability{



    public FileCapability() {
    }

    @Override
    public Map<String, Object> load() {
        try {
            Map<String, Object> map = new HashMap<>();
            // Get config from file
            // khởi tạo 1 đối tượng Properties
            Properties properties = new Properties();

            // load các config từ file web.properties
            properties.load(FileCapability.class.getClassLoader().getResourceAsStream(Constants.PROPERTIES_WEB));

            // set các Capability dựa trên các config trong Properties
            Set<String> keys = properties.stringPropertyNames();
            for (String k : keys) {
                map.put(k, Utils.parseVariables(properties.getProperty(k)));
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
