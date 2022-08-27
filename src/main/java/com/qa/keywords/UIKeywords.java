package com.qa.keywords;

public class UIKeywords extends keywords{
	public void sendKeys(String key, String keysTosend) {
		getElement(key).sendKeys(keysTosend);
	}
}
