package com.qa.amazontests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;
import com.qa.util.PropUtility;
import com.qa.util.*;

public class LoginTest extends TestBase {
	SoftAssert asert = new SoftAssert();

	@Test(priority = 2)
	public void verifySignIn() {
		UIKeywords.launchURL("site_URL");
		String beforeClick = UIKeywords.getTitle();
		UIKeywords.mouseHover("account_Login");
		boolean result = UIKeywords.isDisplayed("sign_in_btn");
		Assert.assertTrue(result, "Sign In Button not displayed on homepage");
		UIKeywords.click("sign_in_btn");
		String afterClick = UIKeywords.getTitle();
		Assert.assertFalse(beforeClick.equals(afterClick), "SignIn button not working");
	}

	@Test(priority = 1)
	public void verifySearchFunctionality() {
		UIKeywords.launchURL("site_URL");
		boolean result = UIKeywords.getElement("home_Search_Txtbox").isDisplayed();
		Assert.assertTrue(result, "Search functionality not present on homepage");
	}

	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void verifyLogin(String UserName,String Password) {
		UIKeywords.launchURL("site_URL");
		UIKeywords.mouseHover("account_Login");
		UIKeywords.click("sign_in_btn");
		Assert.assertTrue(UIKeywords.isDisplayed("user_Name"), "Username textbox not displayed on loginpage");
		UIKeywords.sendKeys("user_Name", UserName);
		UIKeywords.click("continue_btn");
		Assert.assertTrue(UIKeywords.isDisplayed("password"), "password textbox not displayed on loginpage");
		UIKeywords.sendKeys("password", Password);
		UIKeywords.click("sign_In_Submit");
		String text = UIKeywords.getEleTxt("loged_In_User");
		String name=PropUtility.getEnvDetails("customer_Name");
		Assert.assertTrue(text.contains(name), "Invalid user login");
	}

	@Test(priority=3)
	public void verifyEmailErrText() {
		UIKeywords.launchURL("site_URL");
		UIKeywords.mouseHover("account_Login");
		UIKeywords.click("sign_in_btn");
		UIKeywords.click("continue_btn");
		String text = UIKeywords.getEleTxt("email_Missing_errtxt");
		Assert.assertFalse(text.isEmpty(), "No proper errormessage");
	}

	@Test(priority=11)
	public void verifyPasswordErrText() {
		UIKeywords.launchURL("site_URL");
		UIKeywords.mouseHover("account_Login");
		UIKeywords.click("sign_in_btn");
		UIKeywords.sendKeys("user_Name", "userName");
		UIKeywords.click("continue_btn");
		UIKeywords.click("sign_In_Submit");
		String text = UIKeywords.getEleTxt("password_Missing_errtxt");
		Assert.assertFalse(text.isEmpty(), "No proper errormessage");
	}

	@Test(priority=4)
	public void verifyPresenceOfCreateAccountLink() {
		UIKeywords.launchURL("site_URL");
		UIKeywords.mouseHover("account_Login");
		UIKeywords.click("sign_in_btn");
		Assert.assertTrue(UIKeywords.isDisplayed("create_Account_link"), "Create account link is not displayed");
	}

	@Test(priority=7)
	public void verifyCreateAccountLink() {
		UIKeywords.launchURL("site_URL");
		UIKeywords.mouseHover("account_Login");
		UIKeywords.click("sign_in_btn");
		String loginpageTitle = UIKeywords.getTitle();
		UIKeywords.click("create_Account_link");
		String registrationpageTile = UIKeywords.getTitle();
		Assert.assertFalse(loginpageTitle.equalsIgnoreCase(registrationpageTile), "create account link not working");
	}

	@Test(priority=5)
	public void verifyPresenceOfForgotPasswordLink() {
		UIKeywords.launchURL("site_URL");
		UIKeywords.mouseHover("account_Login");
		UIKeywords.click("sign_in_btn");
		UIKeywords.sendKeys("user_Name", "userName");
		UIKeywords.click("continue_btn");
		Assert.assertTrue(UIKeywords.isDisplayed("forgot_Password_link"), "Create account link is not displayed");
	}

	@Test(priority=8)
	public void verifyForgotPasswordLink() {
		UIKeywords.launchURL("site_URL");
		UIKeywords.mouseHover("account_Login");
		UIKeywords.click("sign_in_btn");
		UIKeywords.sendKeys("user_Name", "userName");
		UIKeywords.click("continue_btn");
		String loginpageTitle = UIKeywords.getTitle();
		UIKeywords.click("forgot_Password_link");
		String resetPasswordpageTile = UIKeywords.getTitle();
		System.out.println(loginpageTitle + "   " + resetPasswordpageTile);
		Assert.assertFalse(loginpageTitle.equalsIgnoreCase(resetPasswordpageTile), "create account link not working");
	}

	@Test(priority = 6)
	public void verifyHelpLink() {
		UIKeywords.launchURL("site_URL");
		UIKeywords.mouseHover("account_Login");
		UIKeywords.click("sign_in_btn");
		boolean result = UIKeywords.isDisplayed("help_Link");
		asert.assertTrue(result, "Help link is not displayed");
		UIKeywords.click("help_Link");
		boolean result1 = UIKeywords.isDisplayed("expanded_Help_Links");
		asert.assertTrue(result1, "Help link is not clickable");
		asert.assertAll();
	}

	@Test(priority = 9,description  = "This method verifies the functionality of keep signed in functionality on login page")
	public void verifyChbxFunctionality() {
		UIKeywords.launchURL("site_URL");
		UIKeywords.mouseHover("account_Login");
		UIKeywords.click("sign_in_btn");
		UIKeywords.sendKeys("user_Name", "userName");
		UIKeywords.click("continue_btn");
		boolean result1 = UIKeywords.getElement("remember_Me_chbx").isSelected();
		UIKeywords.click("remember_Me_chbx");
		boolean result2 = UIKeywords.getElement("remember_Me_chbx").isSelected();
		asert.assertNotEquals(result1, result2 + "Checkbox is not clickable");
		UIKeywords.click("remember_chbx_Details_Link");
		boolean result3 = UIKeywords.isDisplayed("remember_chbx_Details_Link_msg");
		asert.assertTrue(result3, "Details link is not working");
		asert.assertAll();
	}

	@Test(priority=10,description = "This method verifies all the links present on loginpage in footersection")
	public void verifyFooterLinks() {
		UIKeywords.launchURL("site_URL");
		UIKeywords.mouseHover("account_Login");
		UIKeywords.click("sign_in_btn");
		List<WebElement> footerlinks = UIKeywords.getLinkText("footer_Section_Links");
		for (WebElement link : footerlinks) {
			UIKeywords.click(link);
		}
		List<String> linkTitles = UIKeywords.getWindowTitles();
		for (String title1 : linkTitles) {
			System.out.println(title1);
		}

	} 
		
}
