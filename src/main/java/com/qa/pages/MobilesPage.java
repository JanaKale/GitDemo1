package com.qa.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;
import com.qa.keywords.keywords;
import com.qa.util.WaitFor;

public class MobilesPage extends TestBase {
	private static final Logger log = Logger.getLogger(MobilesPage.class);
	// @FindBy(css = "#s-refinements div:first-child ul li:nth-child(3)")
	@FindBy(xpath = "//span[text()='Smartphones & Basic Mobiles']")
	public WebElement smartphonesAndBasicMobiles;

	// @FindBy(css="#s-refinements div:first-child ul li:nth-child(5) a")
	@FindBy(xpath = "//span[text()='Smartphones']")
	public WebElement smartphones;

	@FindBy(css = "a[href*='Redmi-9A-Sport-Octa-core'][class='a-link-normal octopus-pc-item-link']")
	public WebElement redmi9A;

	@FindBy(css = "#add-to-cart-button")
	public WebElement addToCart;

	@FindBy()
	public WebElement proceedToCheckout;
	
	@FindBy(css = ".a-size-medium-plus.a-color-base.sw-atc-text.a-text-bold")
	public WebElement addedToCart;
	
	@FindBy(css="div[id='attach-desktop-sideSheet']")
	public WebElement sideSheet;
	
	@FindBy(css="#attach-accessory-pane")
	public WebElement side;

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
		//addedToCart=side.findElement(By.cssSelector("#attach-added-to-cart-message div#attachDisplayAddBaseAlert span"));
	String text=addedToCart.getText();
	System.out.println(text);
		return true;
	}
}
