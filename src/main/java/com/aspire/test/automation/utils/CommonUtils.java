package com.aspire.test.automation.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static com.aspire.test.automation.constants.FrameworkConstants.CONFIG_FOLDER;
import static com.aspire.test.automation.constants.FrameworkConstants.PROPERTY_FILE_PATH;

/**
 * Class Description: This class holds all the Java Common Util methods
 */
public class CommonUtils {

	private CommonUtils() {
		throw new IllegalStateException("Common Utils class");
	}

	private Properties properties;
	static Properties prop = new Properties();

	private static void loadConfigDetails() throws Exception {
		File configFile = null;
		InputStream input = null;
		String configFolderPath = CONFIG_FOLDER;

		if(null == configFolderPath){
			configFolderPath = "src/main/resources/config";
		}

		configFile = new File(PROPERTY_FILE_PATH);
		input = new FileInputStream(configFile);
		prop.load(input);
	}

	public static String getConfigProperty(String key){
		if (prop.isEmpty()){
			try{
				loadConfigDetails();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return prop.getProperty(key) != null ? prop.getProperty(key).trim() : null;
	}

	public static void setConfigProperty(String key, String value){
		if (prop.isEmpty()){
			try{
				loadConfigDetails();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		prop.setProperty(key, value) ;
	}

}
