package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelSupplier {

	public  List<String> readExcelData(String fileName,String sheetName) throws IOException {
		List<String> categories = new ArrayList();
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getPhysicalNumberOfRows();
		int cells = sheet.getRow(0).getLastCellNum();
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cells; j++) {
				categories.add(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
		workbook.close();
		fis.close();
		return categories;
	}
	public  List<String> readCategories() throws IOException {
		return readExcelData("./src/test/resources/excel_TestData/Topwear_categories.xlsx", "category");
				}
}
