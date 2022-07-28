package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.keywords.UIKeywords;
import com.qa.util.WaitFor;

public class MenTshirtPage {

	@FindBy(xpath = "//a[@data-reactid='31']")
	public WebElement Tshirt;

	@FindBy(xpath = "//div[@class='sort-sortBy']")
	public WebElement sortByFilter;

	@FindBy(xpath = "//ul/li/label/input[@value='popularity']")
	public WebElement Popularity;

	public MenTshirtPage() {
		PageFactory.initElements(UIKeywords.driver, this);
	}

	public void clickOnTshirt() {
		Tshirt.click();
	}

	public void clickOnSortByFilter() {
		UIKeywords.mouseHover("sortByFilter");
	}

	public void clickOnPopularity() {
		//JavascriptExecutor js = UIKeywords.driver;
		//js.executeScript("document.querySelector(\"input[value='popularity']\").click()\r\n");
		//js.executeScript("arguments[0].click()", Popularity);
		UIKeywords.driver.executeScript("arguments[0].click()", Popularity);
	}
}
