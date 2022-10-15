package myntratest;

import org.testng.annotations.Test;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;
import com.qa.pages.MenTshirtPage;

public class MenTshirtTest extends TestBase{
	@Test
public void verifyIfSearchByPopularityYieldsProperresult(){
		UIKeywords.driver.get("https://www.myntra.com/");
		UIKeywords.mouseHover("men_Menu");
		MenTshirtPage mp=new MenTshirtPage();
		mp.clickOnTshirt();
		log.info("clicked on Tshirt");
		mp.clickOnSortByFilter();
		log.info("clicked on sortby filter");
		mp.clickOnPopularity();	
		log.info("clicked on popularity filter");
    }
}
    