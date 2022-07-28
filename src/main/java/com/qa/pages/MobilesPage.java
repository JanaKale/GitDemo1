package com.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;
import com.qa.util.WaitFor;

public class MobilesPage extends TestBase {
	private static final Logger log = Logger.getLogger(MobilesPage.class);
	// @FindBy(css = "#s-refinements div:first-child ul li:nth-child(3)")
	@FindBy(xpath = "//span[text()='Smartphones & Basic Mobiles']")
	public WebElement smartphonesAndBasicMobiles;

	// @FindBy(css="#s-refinements div:first-child ul li:nth-child(5) a")
	@FindBy(xpath = "//span[text()='Smartphones']")
	public WebElement smartphones;

	@FindBy(css = ".a-column.a-span12.aok-float-right>div:nth-child(2) div.a-section.octopus-pc-card-content li.octopus-pc-item.octopus-pc-item-v3 a[title*='Redmi 9A']")
	public WebElement redmi9A;

	@FindBy(css = "#add-to-cart-button")
	public WebElement addToCart;

	@FindBy(css = "#attach-added-to-cart-message div#attachDisplayAddBaseAlert span")
	public WebElement addedToCart;

	public MobilesPage() {
		PageFactory.initElements(UIKeywords.driver, this);
	}

	public void clickOnSmartphonesAndBasicMobiles() {
		smartphonesAndBasicMobiles.click();
		log.info("Clicked on Smartphones and basic mobiles");
	}

	public void clickOnSmartphones() {
		WaitFor.eleToBePresent(smartphones);
		smartphones.click();
		log.info("Clicked on Smartphones");
	}

	public void clickOnredmi9A() {
		redmi9A.click();
		log.info("Clicked on Redmi 9A");
	}

	public void clickOnaddTocart() {
		addToCart.click();
		log.info("Clicked on Add to cart button");
	}

	public boolean validateAddedToCart() {
		System.out.println(UIKeywords.driver.getWindowHandles().size());
		return addedToCart.isDisplayed();
	}
}
