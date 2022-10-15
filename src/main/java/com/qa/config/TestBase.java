package com.qa.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.keywords.UIKeywords;
import com.qa.util.PropUtility;

public class TestBase {
	public static final Logger log = Logger.getLogger(TestBase.class);

	// @Parameters("browserName")
	@BeforeMethod
	public void setUp() throws Exception {
		FileInputStream fis = null;
		Properties property = new Properties();
		//String baseDir = System.getProperty("user.dir");
		//String filepath = baseDir + "/src/main/resources/Environment.properties";
		fis = new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources/Environment.properties");
		property.load(fis);

		String browserName = System.getProperty("browser")!=null?System.getProperty("browser"):property.getProperty("browser");
		UIKeywords.openBrowser(browserName);
		log.info("browser open");
	}

	@AfterMethod
	public void close() throws Exception {
		Thread.sleep(3000);
		UIKeywords.tearDown();
		log.info("Browser is closed");
	}
}