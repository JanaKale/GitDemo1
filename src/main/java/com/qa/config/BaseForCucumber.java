package com.qa.config;

import org.apache.log4j.Logger;

import com.qa.keywords.UIKeywords;
import com.qa.util.PropUtility;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class BaseForCucumber {
	private static final Logger log = Logger.getLogger(TestBase.class);
	@Before
	public void setUp() throws Exception {
		String browserName=PropUtility.getEnvDetails("browser");
		UIKeywords.openBrowser(browserName);
		log.info("browser open");
	}   
   // @After
	public void close()throws Exception {
		UIKeywords.tearDown();
		log.info("Browser is closed");
	}
    /*
    @BeforeStep
    public void printHi() {
    	System.out.println("Hi");
    }
    @AfterStep
    public void printBye() {
    	System.out.println("Bye");
    }
    */
}
