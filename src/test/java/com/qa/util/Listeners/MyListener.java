package com.qa.util.Listeners;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.config.TestBase;
import com.qa.keywords.UIKeywords;
import com.qa.util.ExtentReportUtility;
import com.qa.util.ScreenshotUtility;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListener extends TestBase implements ITestListener {
	ExtentReports extent = ExtentReportUtility.getReportObject();
	ExtentTest test;
ThreadLocal <ExtentTest>extentTest=new ThreadLocal<ExtentTest>();
@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//It will set unique thread id
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		String filepath=null;;
		try {
			filepath = ScreenshotUtility.getScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
				extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "test passed");
	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
