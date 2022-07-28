package com.qa.util;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "LoginData")
	public Object[][]LoginDataProvider() throws IOException {
		ExcelReader excel = new ExcelReader();
		return excel.loadData("./src/test/resources/excel_TestData/TestData.xlsx", "LoginData");

	}
	@DataProvider(name = "RegData")
	public Object[][] RegDataProvider() throws IOException {
		ExcelReader excel = new ExcelReader();
		return excel.loadData("./src/test/resources/excel_TestData/TestData.xlsx", "RegData");

	}
}
