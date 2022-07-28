package com.qa.util.Listeners;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

	public class MyListener extends TestBase implements ITestListener {
		
		@Override
		public void onTestFailure(ITestResult result) {
			String testmethodName=result.getMethod().getMethodName();
			AShot ashot = new AShot();
			ashot.shootingStrategy(ShootingStrategies.viewportPasting(0));
			BufferedImage img = ashot.takeScreenshot(UIKeywords.driver).getImage();
			try {
				ImageIO.write(img, "PNG", new File("Screenshots/"+testmethodName+"_"+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

