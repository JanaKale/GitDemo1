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
		UIKeywords.driver.get("https://www.myntra.com/");
		UIKeywords keyword=new UIKeywords();
		keyword.sendKeys("search_box", "key");
		log.info("polo entered in searchbox");
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
		UIKeywords.driver.get("https://www.myntra.com/");
		UIKeywords.mouseHover("men_Menu");
		UIKeywords.click("topwear_link");
		log.info("clicked on topwear link");
		List<String> actualCategories = UIKeywords.getText("categories");
		log.info("list of categories got");
		actualCategories = actualCategories.stream().map(cat -> cat.split("\\(")[0]).collect(Collectors.toList());
		Assert.assertTrue(actualCategories.containsAll(expectedcategories), "category List not matched");
	}

}
