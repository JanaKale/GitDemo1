package com.qa.config;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.keywords.UIKeywords;

public class TestBase {
private static final Logger log = Logger.getLogger(TestBase.class);
	@Parameters("browserName")
	@BeforeMethod
	public void setUp(@Optional("chrome") String browserName) throws Exception {
		/*if(browserName==null) {
			UIKeywords.openBrowser("chrome");
		}
		else if(browserName.isEmpty()) {
			UIKeywords.openBrowser("chrome");
		}*/
		UIKeywords.openBrowser(browserName);
		log.info("browser open");
	}   
    @AfterMethod
	public void close()throws Exception {
		Thread.sleep(3000);
		UIKeywords.tearDown();
		log.info("Browser is closed");
	}
}
