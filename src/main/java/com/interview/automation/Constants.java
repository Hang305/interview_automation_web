package com.interview.automation;


public class Constants {

    Constants() {
    }
    public static final String PROPERTIES_WEB = "web.properties";

    public static final String DRIVER_TYPE_CHROME = "chrome";
    public static final String DRIVER_TYPE_FIREFOX = "firefox";
    public static final String DRIVER_TYPE_SAFARI = "safari";
    public static final String DRIVER_TYPE_EDGE = "edge";
    public static final String ENV_LOCAL = "local";
    public static final String ENV_REMOTE = "remote";
    public static final String DOT = ".";

    // capabilities
    public static final String PREFIX_SELENIUM = "web.";
    public static final String CONFIGURATION_REMOTE_HOST = "remote.url";
    public static final String CONFIGURATION_DRIVER_PATH = "driver.path";

    public static final String TEST_OUTPUT_DIR = "TestResults";
    public static final String LOGFILE_PATH = TEST_OUTPUT_DIR + "/Logs";
    public static final String REPORT_PATH = TEST_OUTPUT_DIR + "/Reports";
    public static final String SCREENSHOT_PATH = TEST_OUTPUT_DIR + "/Screenshots";

    // Time out in seconds
    public static final int SHORT_TIME = 5;
    public static final int MEDIUM_TIME = 10;
    public static final int LONG_TIME = 30;

    //Error message
    public static final String EMPTY_TASK_NAME = "Please add a task name";
    public static final String WITHOUT_SELECTING_A_METRIC = "Please select at least one metric";

}
