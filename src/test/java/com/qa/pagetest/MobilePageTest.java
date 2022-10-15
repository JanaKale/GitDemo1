package com.qa.pagetest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;
import com.qa.pages.HomePage;
import com.qa.pages.MobilesPage;

public class MobilePageTest extends TestBase {
	@Test
	public void Test() {
		UIKeywords.launchURL("site_URL");
		HomePage home = new HomePage();

		MobilesPage mob = home.clickOnMobiles();
		mob.clickOnSmartphonesAndBasicMobiles();
		mob.clickOnSmartphones();
		mob.clickOnredmi9A();
		mob.clickOnaddTocart();
		Assert.assertTrue(mob.validateAddedToCart(), " mobile not added to cart");
		log.info("redmi9A added to cart successfully");
	}

}
    