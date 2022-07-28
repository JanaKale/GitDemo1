package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtility {
	public static String getValue(String filepath, String key) {
		FileInputStream fis = null;
		Properties property = new Properties();
		/*
		 * try { fis = new FileInputStream(filepath); } catch (FileNotFoundException e)
		 * { System.err.println("File not found" + filepath); } Properties property =
		 * new Properties(); try { property.load(fis); } catch (IOException e) {
		 * System.err.println("Unable to load properties file" + filepath); }
		 */
		try {
			fis = new FileInputStream(filepath);
			property.load(fis);
		} catch (FileNotFoundException e) {
			System.err.println("File not found" + filepath);
		} catch (IOException e) {
			System.err.println("Unable to load properties file" + filepath);
		}

		return property.getProperty(key);

	}

	/**
	 * This method can be used for OR.properties file only
	 * 
	 * @param key for which we want the locator
	 * @return locator value for the key in the form of {@code String}
	 */

	public static String getObject(String key) {
		String baseDir = System.getProperty("user.dir");
		return getValue(baseDir + "/src/main/resources/OR.properties", key);
	}

	/**
	 * This method can be used for Environment.properties file only
	 * 
	 * @param key
	 * @return{@code String}
	 */
	public static String getEnvDetails(String key) {
		String baseDir = System.getProperty("user.dir");
		return getValue(baseDir + "/src/main/resources/Environment.properties", key);
	}
}
