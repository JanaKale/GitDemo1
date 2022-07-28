package com.qa.pagetest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;
import com.qa.pages.BooksPage;
import com.qa.pages.FashionPage;
import com.qa.pages.HomePage;
import com.qa.pages.MobilesPage;

public class HomePageTest extends TestBase {
	private static final Logger log = Logger.getLogger(HomePageTest.class);
	static HomePage homePage;

	@Test(priority = 1)
	public void validateHomePageTitleTest() {
		UIKeywords.launchURL("site_URL");
		homePage = new HomePage();
		String title = homePage.verifyHomePageTitle();
		log.info("Home Page Title:");
		log.info(title);
		Assert.assertEquals(title,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	@Test(priority = 2)
	public void validateSiteLogo() {
		UIKeywords.launchURL("site_URL");
		homePage = new HomePage();
		String logotxt=homePage.verifySiteLogo();
		Assert.assertEquals(logotxt, "Amazon");
	}

	@Test(priority = 3)
	public void validateSignInLinkTest() {
		UIKeywords.launchURL("site_URL");
		homePage = new HomePage();
		homePage.mouseMoveOnAccountAndLists();
		String loginPageTitle = homePage.clickOnSignInLink();
		Assert.assertEquals(loginPageTitle, "Amazon Sign In");
	}
}
