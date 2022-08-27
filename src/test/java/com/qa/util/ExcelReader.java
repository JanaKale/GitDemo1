package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public Object[][] loadData(String filename, String sheetname) throws IOException {
		Object[][] obj = null;
		Workbook book = null;
		FileInputStream fis = new FileInputStream(filename);
		
		book=WorkbookFactory.create(fis);
		
		/* if (filename.endsWith("xls")) {
			book = new HSSFWorkbook(fis);
		} else if (filename.endsWith("xlsx")) {
			book = new XSSFWorkbook(fis);
		} */
		
		Sheet sheet = book.getSheet(sheetname);
		obj=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
		for (int j = 1; j <= sheet.getLastRowNum(); j++) {
			Row row = sheet.getRow(j);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				Cell cell = row.getCell(i);
				switch (cell.getCellType()) {
				case NUMERIC:
					obj[j-1][i] =String.valueOf( cell.getNumericCellValue());
					break;
				case STRING:
					obj[j-1][i] = cell.getStringCellValue();
					break;
				default:
					break;

				}				
			}
		}
		return obj;
   }
}
