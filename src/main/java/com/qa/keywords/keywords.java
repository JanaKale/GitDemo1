package com.qa.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.util.PropUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class keywords {
	public static RemoteWebDriver driver;
	private static final Logger log = Logger.getLogger(keywords.class);

	public static void openBrowser(String browsername) {
		switch (browsername.toLowerCase()) {
		case "chrome":
			ChromeOptions option = new ChromeOptions();
			//option.addArguments("headless");
			option.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public static void tearDown() {
		driver.close();
	}

	public static void launchURL(String url) {
		String URL = PropUtility.getEnvDetails(url);
		driver.get(URL);
		log.info("URL is launched  " + URL);
	}

	public static boolean isDisplayed(String key) {
		boolean result = getElement(key).isDisplayed();
		return result;
	}

	public void sendKeys(String key, String keysTosend) {
		String KTS = PropUtility.getEnvDetails(keysTosend);
		getElement(key).sendKeys(KTS);
	}

	public static void sendKeys(WebElement element, String keysTosend) {
		String KTS = PropUtility.getEnvDetails(keysTosend);
		element.sendKeys(KTS);
	}

	public static void click(String key) {
		getElement(key).click();
	}

	public static void click(WebElement key) {
		key.click();
	}

	public static void hitButton(int keycode) {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(keycode);
		robot.keyRelease(keycode);
	}

	public static void switchToWindow(String byTitle) {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!driver.switchTo().window(window).getTitle().equals(byTitle)) {
				log.info("Switched to window:" + byTitle);
				break;
			}
		}
	}

	public static WebElement getElement(String locatorkey) {
		String locatorType = PropUtility.getObject(locatorkey).split("##")[0];
		String locatorValue = PropUtility.getObject(locatorkey).split("##")[1];
		WebElement element = null;
		switch (locatorType.toLowerCase()) {
		case "xpath":
			element = driver.findElement(By.xpath(locatorValue));
			break;
		case "cssselector":
			element = driver.findElement(By.cssSelector(locatorValue));
			break;
		case "tagname":
			element = driver.findElement(By.tagName(locatorValue));
			break;
		case "classname":
			element = driver.findElement(By.className(locatorValue));
			break;
		case "id":
			element = driver.findElement(By.id(locatorValue));
			break;
		case "name":
			element = driver.findElement(By.name(locatorValue));
			break;
		case "linktext":
			element = driver.findElement(By.linkText(locatorValue));
			break;
		case "partiallinktext":
			element = driver.findElement(By.partialLinkText(locatorValue));
			break;
		default:
			log.info("Invalid locator Type" + locatorType);
			break;
		}
		return element;

	}

	public static List<WebElement> getElements(String locatorkey) {
		String locatorType = PropUtility.getObject(locatorkey).split("##")[0];
		String locatorValue = PropUtility.getObject(locatorkey).split("##")[1];
		List<WebElement> elements = null;
		switch (locatorType.toLowerCase()) {
		case "xpath":
			elements = driver.findElements(By.xpath(locatorValue));
			break;
		case "cssselector":
			elements = driver.findElements(By.cssSelector(locatorValue));
			break;
		case "tagname":
			elements = driver.findElements(By.tagName(locatorValue));
			break;
		case "classname":
			elements = driver.findElements(By.className(locatorValue));
			break;
		case "id":
			elements = driver.findElements(By.id(locatorValue));
			break;
		case "name":
			elements = driver.findElements(By.name(locatorValue));
			break;
		case "linktext":
			elements = driver.findElements(By.linkText(locatorValue));
			break;
		case "partiallinktext":
			elements = driver.findElements(By.partialLinkText(locatorValue));
			break;
		default:
			log.info("Invalid locator Type" + locatorType);
			break;
		}
		return elements;

	}

	public static void mouseHover(String key) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(key)).perform();

	}

	public static void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		;
	}

	public static List<String> getText(String key) {
		List<WebElement> WebElementList = getElements(key);
		List<String> txtlist = new ArrayList<>();
		for (WebElement element : WebElementList) {
			String txt = element.getText();
			txtlist.add(txt);
		}
		return txtlist;
	}

	public static List<String> getText(List<WebElement> WebElementList) {
		List<String> txtlist = new ArrayList<>();
		for (WebElement element : WebElementList) {
			String txt = element.getText();
			txtlist.add(txt);
		}
		return txtlist;
	}

	public static String getEleTxt(String key) {
		String text = getElement(key).getText();
		return text;
	}

	public static String getTitle() {
		return driver.getTitle();
	}

	public static List<WebElement> getLinkText(String string) {
		List<WebElement> links = getElements("footer_Section_Links");
		return links;
	}

	public static String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public static String getHandle() {
		return driver.getWindowHandle();

	}

	public static void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static List<String> getWindowTitles() {
		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		List<String> titles = new ArrayList<String>();
		for (String handle : handles) {
			titles.add(driver.switchTo().window(handle).getTitle());
		}
		return titles;
	}

}
