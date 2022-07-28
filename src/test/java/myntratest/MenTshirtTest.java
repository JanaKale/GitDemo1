package myntratest;

import org.testng.annotations.Test;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;
import com.qa.pages.MenTshirtPage;

public class MenTshirtTest extends TestBase{
	@Test
public void verifyIfSearchByPopularityYieldsProperresult(){
		UIKeywords.launchURL("URL");
		UIKeywords.mouseHover("men_Menu");
		MenTshirtPage mp=new MenTshirtPage();
		mp.clickOnTshirt();
		mp.clickOnSortByFilter();
		mp.clickOnPopularity();
		
}
}
 