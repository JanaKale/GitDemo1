package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

import com.qa.keywords.UIKeywords;
import com.qa.util.WaitFor;

public class FashionPage {
	By women = By.cssSelector("#nav-progressive-subnav a:nth-child(2) .nav-a-content");
	By sarees = By.cssSelector("a[href*=s23_1_1_1_11]");
	By chiffonChbx = By.cssSelector("#s-refinements div:nth-child(5) ul li:nth-child(2) input");
	By brandsList = By.cssSelector("ul[aria-labelledby=p_89-title] li");
	By sirilChbx = By.cssSelector(" li[id='p_89/SIRIL']");
	By sareeList = By.cssSelector("span[class='a-size-base-plus a-color-base']");

	public void mousemoveonWomen() {
		WebElement womens = UIKeywords.driver.findElement(women);
		UIKeywords.mouseHover(womens);
	}

	public void clickOnSarees() {
		WaitFor.eleToBePresent(sarees);
		UIKeywords.driver.findElement(sarees).click();
	}

	public void clickonChiffon() {
		WaitFor.elementToBeClickable(chiffonChbx);
		UIKeywords.driver.findElement(chiffonChbx).click();
	}

	public void clickonSiril() {
		WaitFor.elementToBeClickable(sirilChbx);
		UIKeywords.driver.findElement(sirilChbx).click();
	}

	public boolean verifySareesbrand() {
		List<WebElement> list = UIKeywords.driver.findElements(sareeList);
		List<String> sirilBrandList = UIKeywords.getText(list);
		for (String saree : sirilBrandList) {
			if (!saree.equalsIgnoreCase("siril")) {
				return false;
			}
		}
		return true;
	}

}
