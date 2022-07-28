package com.qa.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.keywords.UIKeywords;

public class WaitFor {
	public static WebDriverWait wait = null;
	static {
		wait = new WebDriverWait(UIKeywords.driver, Duration.ofSeconds(60));
		wait.withMessage("waiting over element is not found");
	}

	public static void elementToBeClickable(By key) {
		wait.pollingEvery(Duration.ofMillis(500));
		// wait.ignoring(ElementNotInteractableException.class,NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(key));

	}

	public static void elementToBeClickable(WebElement element) {
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(ElementNotInteractableException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void eleToBePresent(By element) {
		wait.pollingEvery(Duration.ofMillis(500));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	public static void eleToBePresent(WebElement element) {
		wait.pollingEvery(Duration.ofMillis(500));
		wait.until(ExpectedConditions.visibilityOf(element));		
	}

}
