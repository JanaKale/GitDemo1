package com.qa.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.keywords.UIKeywords;
import com.qa.keywords.keywords;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotUtility extends keywords{
	public static String getScreenshot(String methodname) throws IOException {
		String testmethodName = methodname;
	/*File file=driver.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"Screenshots/" + testmethodName + "_" + ".png"));
		return "//Screenshots//" + testmethodName +".png";
		*/
	AShot ashot = new AShot();
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(0));
		BufferedImage img = ashot.takeScreenshot(UIKeywords.driver).getImage();
		try {
			 ImageIO.write(img, "PNG", new File("Screenshots/" + testmethodName + "_" + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "//Screenshots//" + testmethodName +".png";

	}
}
