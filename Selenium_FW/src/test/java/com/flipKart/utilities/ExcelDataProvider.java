package com.flipKart.utilities;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {
		File src = new File("C:\\Users\\Devraj\\eclipse-workspace\\Selenium_FW\\TestData\\testdata.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getStringData(String SheetName, int row, int col) {
		return wb.getSheet(SheetName).getRow(row).getCell(col).getStringCellValue();
	}

	public String getStringData(int index, int row, int col) {
		return wb.getSheetAt(index).getRow(row).getCell(col).getStringCellValue();
	}

	public String getNumericData(String SheetName, int row, int col) {
		double value = wb.getSheet(SheetName).getRow(row).getCell(col).getNumericCellValue();
		String data = value+"";
		return data;
	}

	public String getNumericData(int index, int row, int col) {
		double value = wb.getSheetAt(index).getRow(row).getCell(col).getNumericCellValue();
		String data = value+"";
		return data;
	}

}
