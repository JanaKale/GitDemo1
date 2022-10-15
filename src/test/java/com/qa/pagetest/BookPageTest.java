package com.qa.pagetest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;
import com.qa.pages.BooksPage;
import com.qa.pages.HomePage;

public class BookPageTest extends TestBase{
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

}
