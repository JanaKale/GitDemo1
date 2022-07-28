package com.qa.amazontests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;
import com.qa.util.DataProviders;

public class AccountRegTest extends TestBase {
	@Test
	public void verifyStartHereLink() {
		UIKeywords.mouseHover("account_Login");
		String title = UIKeywords.getTitle();
		UIKeywords.click("start_Here_link");
		String title1 = UIKeywords.getTitle();
		Assert.assertFalse(title.equalsIgnoreCase(title1), "Strat Here link is not clickable");
		
	}

	@Test
	public void verifycontinueButton() {
		UIKeywords.launchURL("site_URL");
		UIKeywords.mouseHover("account_Login");
		UIKeywords.click("start_Here_link");
		UIKeywords.click("continue_btn");
		String errmsg = UIKeywords.getEleTxt("name_Missing_errtext");
		Assert.assertTrue(!errmsg.isEmpty(), "Continue button is not working properly");
	}

	@Test
	public void verifySignInLink() {
		UIKeywords.launchURL("site_URL");
		UIKeywords.mouseHover("account_Login");
		UIKeywords.click("start_Here_link");
		String registrationpageTitle = UIKeywords.getTitle();
		UIKeywords.click("sign_In_Link");
		String loginpageTile = UIKeywords.getTitle();
		Assert.assertFalse(registrationpageTitle.equals(loginpageTile));
	}
	@Test
	public void verifyBusinessAccountLink() {
		UIKeywords.launchURL("site_URL");
		UIKeywords.mouseHover("account_Login");
		UIKeywords.click("start_Here_link");
		String registrationpageTitle = UIKeywords.getTitle();
		UIKeywords.click("business_account_Link");
		String loginpageTile = UIKeywords.getTitle();
		Assert.assertFalse(registrationpageTitle.equals(loginpageTile));
		//UIKeywords.sendKeys("business_Email", "business_Email");
		//UIKeywords.click("get_Started_btn");
	}
	@Test(dataProvider = "RegData",dataProviderClass = DataProviders.class)
	public void fillRegistrationForm(String name,String email,String alt_email,String password){
		UIKeywords.launchURL("site_URL");
		UIKeywords.mouseHover("account_Login");
		UIKeywords.click("start_Here_link");
		UIKeywords.sendKeys("customer_Name_txtbx",name);
		UIKeywords.sendKeys("emailORmobile_No_txtbx", email);
		UIKeywords.sendKeys("alternate_Email_txtbx", alt_email);
		UIKeywords.sendKeys("password_txtbx", password);
		UIKeywords.click("continue_btn");	
		
	}
}
