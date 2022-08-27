package com.qa.amazontests;

import java.awt.event.KeyEvent;
import java.util.List;

import org.testng.annotations.Test;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;

public class ProductSearchTest extends TestBase{

	@Test
	public void getlist() {
		UIKeywords.launchURL("site_URL");
		UIKeywords.click("all_Menu_btn");
		List<String> hmenu_item = UIKeywords.getText("home_Menu_List");
		hmenu_item.stream().forEach(m -> System.out.println(m));
	}

	@Test
	public void searchProduct() throws InterruptedException {
		UIKeywords.launchURL("site_URL");
		UIKeywords uikeyword=new UIKeywords();
		uikeyword.sendKeys("home_Search_Txtbox", "text_To_Search");
		Thread.sleep(5000);
		// UIKeywords.waitFor("home_Search_Txtbox");
		UIKeywords.hitButton(KeyEvent.VK_ENTER);
		List<String> laptop_List = UIKeywords.getText("laptop_List");
		// laptop_List.stream().forEach(l->System.out.println(l.contains("laptop")));
		laptop_List.stream().forEach(l -> System.out.println(l));
		// long count= laptop_List.stream().filter(l->l.contains("laptop")).count();
		System.out.println(laptop_List.size());
		// System.out.println(count);
	}
}
