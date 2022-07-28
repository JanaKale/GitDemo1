package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;
import com.qa.util.PropUtility;
import com.qa.util.WaitFor;

public class LoginPage extends TestBase{
	static HomePage homePage;
	@FindBy(xpath = "//input[@type='email']")
	public WebElement emailTxtbx;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement continueBtn;

	@FindBy(xpath = "//input[@type='password']")
	public WebElement passwordTxtbx;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	public WebElement submitBtn;

	@FindBy(xpath = "//span[@class='a-expander-prompt']")
	public WebElement helpLink;

	@FindBy(xpath = "//div[@aria-expanded='true']/a")
	public WebElement expandedHelpLink;

	@FindBy(id = "createAccountSubmit")
	public WebElement createAccountLink;
	
	public LoginPage() {
		PageFactory.initElements(UIKeywords.driver, this);
	}

	public String verifyLoginPageTitle() {
		homePage = new HomePage();
		homePage.mouseMoveOnAccountAndLists();
		WaitFor.eleToBePresent(homePage.SignInLink);
		String loginPagetitle = homePage.clickOnSignInLink();
		return loginPagetitle;
	}

	public void enterEmailOrPhone() {
		UIKeywords.sendKeys(emailTxtbx, "userName");
	}

	public void clickOnContinueBtn() {
		continueBtn.click();
	}

	public void enterPassword() {
		UIKeywords.sendKeys(passwordTxtbx, "password");
	}

	public void clickOnSubmitBtn() {
		submitBtn.click();
	}

	public RegistrationPage verifycreateAccountLink() {
		homePage = new HomePage();
		homePage.mouseMoveOnAccountAndLists();
		WaitFor.eleToBePresent(homePage.SignInLink);
		homePage.clickOnSignInLink();
		createAccountLink.click();
		return new RegistrationPage();
	}

	public boolean verifyHelpLink() {
		homePage = new HomePage();
		homePage.mouseMoveOnAccountAndLists();
		WaitFor.eleToBePresent(homePage.SignInLink);
		homePage.clickOnSignInLink();
		helpLink.click();
		return expandedHelpLink.isDisplayed();
	}
	public String verifyLogin(){
		homePage = new HomePage();
		homePage.mouseMoveOnAccountAndLists();
		WaitFor.eleToBePresent(homePage.SignInLink);
		homePage.clickOnSignInLink();
		UIKeywords.sendKeys(emailTxtbx, "userName");
		continueBtn.click();
		UIKeywords.sendKeys(passwordTxtbx, "password");
		submitBtn.click();
		String userName = UIKeywords.getEleTxt("loged_In_User");
		String name=PropUtility.getEnvDetails("customer_Name");
		System.out.println(userName);
		return userName;
	}
}
