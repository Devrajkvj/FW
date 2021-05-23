package com.flipKart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() {	
		try {
			File src = new File("C:\\Users\\Devraj\\git\\FW\\Selenium_FW\\Configuration\\config - Copy.properties");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load config file"+e.getMessage());
		}
	}
	
	public String getDataFromConfig (String key) {
		return pro.getProperty(key);
	}

}
