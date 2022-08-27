package stepDefinitions;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;

import com.qa.keywords.UIKeywords;
import com.qa.pages.MenTshirtPage;
import com.qa.util.ExcelSupplier;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Serachsteps {

	/*
	 * @Given("ब्राउज़र खोलें") public void openBrowzer() {
	 * UIKeywords.openBrowser("chrome"); }
	 */

	@Given("url लाँच करा")
	public void launchUrl() {
		UIKeywords.launchURL("URL");
	}

	@When("enter polo in search box")
	public void sendkeys() {
		UIKeywords uiKeywords = new UIKeywords();
		uiKeywords.sendKeys("search_box", "key");
	}

	@And("press enter")
	public void hitButton() {
		UIKeywords.hitButton(KeyEvent.VK_ENTER);
	}

	@Then("resulting products should contain polo brand")
	public void result() {
		List<String> productTitles = UIKeywords.getText("product_txt");
		productTitles.forEach(p -> System.out.println(p));
		Assert.assertTrue(productTitles.stream().allMatch(t -> t.contains("Polo")),
				"In result onther than polo brand products also present");
	}

	List<String> expectedcategories;

	@And("read expected category list from excel")
	public void readCategoriesListFromExcel() throws IOException {
		ExcelSupplier obj = new ExcelSupplier();
		expectedcategories = obj.readCategories();
	}

	@And("mouse over on men menu")
	public void mouseOverOnMenMenu() {
		UIKeywords.mouseHover("men_Menu");
	}

	@When("click on topwear link")
	public void click() {
		UIKeywords.click("topwear_link");
	}

	List<String> actualCategories;

	@And("get list of all the categories present in topwear link")
	public void getList() {
		actualCategories = UIKeywords.getText("categories");
		actualCategories = actualCategories.stream().map(cat -> cat.split("\\(")[0]).collect(Collectors.toList());
	}

	@Then("Expected and actual list should be same")
	public void assertion() {
		Assert.assertTrue(actualCategories.containsAll(expectedcategories), "category List not matched");
	}


	@When("user click on Tshirt")
	public void clickTshirt() {
		MenTshirtPage	mp = new MenTshirtPage();
		mp.clickOnTshirt();
	}

	@And("click on sort by filter")
	public void clickOnSortByFilter() {
		MenTshirtPage	mp = new MenTshirtPage();
		mp.clickOnSortByFilter();
	}

	@And("click on popularity filter")
	public void clickOnPopularityFilter() {
		MenTshirtPage	mp = new MenTshirtPage();
		mp.clickOnPopularity();
	}
}
