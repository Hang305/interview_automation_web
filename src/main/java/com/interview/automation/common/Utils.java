package com.interview.automation.common;

import com.interview.automation.exceptions.CommonException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    private Utils(){}

    /**
     * This method is to
     * - Check string contain System environment (pattern ${varName})
     * - Get value from System Variables
     * - Replace pattern String by that value
     *
     * @param text
     * @return
     * @throws CommonException
     */
    public static String parseVariables(String text) throws CommonException {
        String regex = "\\$\\{([^\\\\$\\\\]+)\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

//        remote.url=https://${BS_USERNAME}:${BS_ACCESS_KEY}@hub-cloud.browserstack.com/wd/hub
        String returnString = text;
        while (matcher.find()) {
            String replacedString = matcher.group(0); // ${BS_USERNAME}
            String key = matcher.group(1);
            String replaceValue = System.getenv(key); // tandt
            if (replaceValue == null || replaceValue.isEmpty()) {
                throw new CommonException("System Variable with name " + key + " is not set.");
            }
            returnString = returnString.replace(replacedString, replaceValue);
        }
//            remote.url=https://tandt:access_key_tandt@hub-cloud.browserstack.com/wd/hub
        return returnString;
    }

}
