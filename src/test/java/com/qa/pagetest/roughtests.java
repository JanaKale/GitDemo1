package com.qa.pagetest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;
import com.qa.pages.BooksPage;
import com.qa.pages.FashionPage;
import com.qa.pages.HomePage;
import com.qa.pages.MobilesPage;

public class roughtests extends TestBase{
	private static final Logger log = Logger.getLogger(roughtests.class);
	@Test
	public void Test() {
		UIKeywords.launchURL("site_URL");
		HomePage home = new HomePage();

		home.clickOnMobiles();

		MobilesPage mob = new MobilesPage();
		mob.clickOnSmartphonesAndBasicMobiles();
		mob.clickOnSmartphones();
		mob.clickOnredmi9A();
		mob.clickOnaddTocart();
		Assert.assertTrue(mob.validateAddedToCart(), " mobile not added to cart");
		log.info("redmi9A added to cart successfully");
	}

	@Test
	public void bookTest() throws InterruptedException {
		UIKeywords.launchURL("site_URL");
		HomePage home = new HomePage();

		home.clickOnBooks();

		BooksPage book = new BooksPage();

		book.clickOnTodaysDealschbx();
		book.clickOnSortByDropdown();
		book.clickOnPriceFilter();
		book.clickOnLowestPriceBook();
		book.clickOnAddToCart();
		Assert.assertTrue(book.addedToCart(), "book not added to cart");
		log.info("Todays lowest price book added to cart");
	}
@Test
	public void fashionTest() {
	UIKeywords.launchURL("site_URL");
		HomePage home = new HomePage();
		home.clickOnFashion();
		
		FashionPage fashion=new FashionPage();
		fashion.mousemoveonWomen();
		fashion.clickOnSarees();
		fashion.clickonChiffon();
		fashion.clickonSiril();
		fashion.verifySareesbrand();
	}
}
