package com.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.keywords.UIKeywords;

public class HomePage {
	private static final Logger log = Logger.getLogger(HomePage.class);
	public WebElement account_Lists;
	public WebElement SignInLink;
	public WebElement logo;
	public WebElement mobiles;
	public WebElement fashion;
	public WebElement books;

	public HomePage() {
		account_Lists=UIKeywords.driver.findElement(By.xpath("//div[@class='nav-line-1-container']/span[@class='nav-line-1 nav-progressive-content']"));
		SignInLink=UIKeywords.driver.findElement(By.xpath("//a[@data-nav-ref='nav_signin']/span"));
		logo=UIKeywords.driver.findElement(By.cssSelector("a[aria-label=Amazon]"));
		mobiles = UIKeywords.driver.findElement(By.xpath("//a[text()='Mobiles']"));
		fashion = UIKeywords.driver.findElement(By.xpath("//a[text()='Fashion']"));
		books = UIKeywords.driver.findElement(By.xpath("//a[text()='Books']"));
	}

	public String verifyHomePageTitle() {
		return UIKeywords.driver.getTitle();
	}
	public void mouseMoveOnAccountAndLists() {
		UIKeywords.mouseHover(account_Lists);
	}
	public String clickOnSignInLink() {
		SignInLink.click();
		return UIKeywords.driver.getTitle();
	}
	public String verifySiteLogo() {
		return logo.getAttribute("aria-label");
	}
	public MobilesPage clickOnMobiles() {
		mobiles.click();
		log.info("Clicked on mobiles");
		return new MobilesPage();
	}

	public FashionPage clickOnFashion() {
		fashion.click();
		log.info("Clicked on fashion");
		return new FashionPage();
	}

	public BooksPage clickOnBooks() {
		books.click();
		log.info("Clicked on books");
		return new BooksPage();
	}
}
