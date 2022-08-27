package myntratest;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;
import com.qa.util.ExcelSupplier;

public class ProductTest extends TestBase {
	@Test
	public void verifyPoloSearchResult() {
		UIKeywords.launchURL("URL");
		UIKeywords keyword=new UIKeywords();
		keyword.sendKeys("search_box", "key");
		UIKeywords.hitButton(KeyEvent.VK_ENTER);
		List<String> productTitles = UIKeywords.getText("product_txt");
		productTitles.forEach(p -> System.out.println(p));
		Assert.assertTrue(productTitles.stream().allMatch(t -> t.contains("Polo")),
				"In result onther than polo brand products also present");
	}

	@Test
	public void verifyCategoryList() throws IOException {
		ExcelSupplier obj = new ExcelSupplier();
		List<String> expectedcategories = obj.readCategories();
		UIKeywords.launchURL("URL");
		UIKeywords.mouseHover("men_Menu");
		UIKeywords.click("topwear_link");
		List<String> actualCategories = UIKeywords.getText("categories");
		actualCategories = actualCategories.stream().map(cat -> cat.split("\\(")[0]).collect(Collectors.toList());
		Assert.assertTrue(actualCategories.containsAll(expectedcategories), "category List not matched");
	}

}
