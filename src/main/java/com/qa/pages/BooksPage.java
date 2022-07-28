package com.qa.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;
import com.qa.util.WaitFor;

public class BooksPage extends TestBase {
	private static final Logger log = Logger.getLogger(BooksPage.class);

	By todaysDeals = By.cssSelector(".apb-browse-left-nav div div div:nth-child(14) ul i");
	By sortByDropdown = By.cssSelector(" #a-autoid-0-announce span");
	By priceLowToHigh = By.cssSelector("#s-result-sort-select_1");
	By books = By.cssSelector(".a-size-medium.a-color-base.a-text-normal");
	By addToCart = By.cssSelector("#add-to-ebooks-cart-button");
	By addedToCart = By.xpath("//span[contains(text(),'Added to eBook')]");

	public void clickOnTodaysDealschbx() {
		UIKeywords.driver.findElement(todaysDeals).click();
		log.info("clicked On TodaysDeals chbx");
	}

	public void clickOnSortByDropdown() {
		UIKeywords.driver.findElement(sortByDropdown).click();
		log.info("clicked On SortByDropdown");
	}

	public void clickOnPriceFilter() {
		WaitFor.elementToBeClickable(priceLowToHigh);
		UIKeywords.driver.findElement(priceLowToHigh).click();
		log.info("clicked On price Low To High Filter");
	}

	public void clickOnLowestPriceBook() {
		List<WebElement> booklist = UIKeywords.driver.findElements(books);
		log.info(booklist.size());
		booklist.get(0).click();
		log.info("todays lowest price book selected to add in cart ");
	}

	public void clickOnAddToCart() {
		System.out.println(UIKeywords.getWindowTitles().get(0));
		System.out.println(UIKeywords.getWindowTitles().get(1));
		WaitFor.elementToBeClickable(addToCart);
		UIKeywords.driver.findElement(addToCart).click();
		log.info("clicked on add to cart button");
	}

	public boolean addedToCart() {
		WaitFor.eleToBePresent(addedToCart);
		return UIKeywords.driver.findElement(addedToCart).isDisplayed();
	}
}
