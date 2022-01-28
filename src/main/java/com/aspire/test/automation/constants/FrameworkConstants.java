package com.aspire.test.automation.constants;

/**
 * This class holds all Framework constants
 *
 */
public class FrameworkConstants {

	private FrameworkConstants() {
		throw new IllegalStateException("Framework Constants Class");
	}

	public static final String RESOURCES_FOLDER = "src/main/resources/";
	public static final String OUTPUT_FOLDER="target/";

	public static final String CONFIG_FOLDER = RESOURCES_FOLDER + "configs/";
	public static final String XML_CONFIG_FOLDER=CONFIG_FOLDER+"xml-configs/";
	public static final String TESTNG_FILE_PATH =  XML_CONFIG_FOLDER + "testng.xml";
	public static final String PROPERTIES_CONFIG_FOLDER=CONFIG_FOLDER+"property-configs/";
	public static final String PROPERTY_FILE_PATH = PROPERTIES_CONFIG_FOLDER + "configurations.properties";

	public static final String DRIVERS_FOLDER = RESOURCES_FOLDER + "drivers/";
	public static final String CHROME_DRIVER = DRIVERS_FOLDER + "chromedriver.exe";

	public static final String FAILED_SCENARIO_SCREENSHOT_FOLDER="screenshots-fail";
	public static final String SCREENSHOT_IMG_FILE_FORMAT="png";
	public static final String IMG_PNG_MIME_TYPE="image/png";

}
