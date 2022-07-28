package com.qa.pagetest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;
import com.qa.pages.LoginPage;
import com.qa.pages.RegistrationPage;
import com.qa.util.PropUtility;
import com.qa.util.Listeners.MyListener;
@Listeners(MyListener.class)
public class LoginPageTest extends TestBase {
	static LoginPage loginPage;

	// retryAnalyzer =com.qa.util.MyRetryAnalyzer.class
	@Test(priority = 1)
	public void validateLoginPageTitleTest() {
		UIKeywords.launchURL("site_URL");
		loginPage = new LoginPage();
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "Amazon Sign In");
	}

	@Test(priority = 2)
	public void validateHelpLinkTest() {
		UIKeywords.launchURL("site_URL");
		loginPage = new LoginPage();
		Assert.assertTrue(loginPage.verifyHelpLink(), "HelpLink not working");
	}

	@Test
	public void validateCreateAccountLinkTest() {
		UIKeywords.launchURL("site_URL");
		loginPage = new LoginPage();
		RegistrationPage regPage = loginPage.verifycreateAccountLink();
		Assert.assertTrue(regPage.verifyRegPageTitle().equalsIgnoreCase("Amazon"), "Create account Link Not working");
	}

	@Test
	public void verifyLoginTest() {
		UIKeywords.launchURL("site_URL");
		loginPage = new LoginPage();
		String loggedInUser = loginPage.verifyLogin();
		String userName=PropUtility.getEnvDetails("customer_Name");
		Assert.assertEquals(loggedInUser,userName);
	}

}
