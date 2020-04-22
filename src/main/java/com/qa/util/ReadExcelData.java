package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ReadExcelData(String excelPath) {
		try {
			File src = new File(excelPath);
				FileInputStream fis = new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
		} 
			catch (Exception e) {
				System.out.println(e.getMessage());
		}
		
	}
	
	public String getData(int sheetNumber, int row, int column) {
		sheet = wb.getSheetAt(sheetNumber);
		String data= sheet.getRow(row).getCell(column).getStringCellValue(); 
		return data; 
	}
	
	public int getRowCount(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row=row+1;
		return row;
		
	}
	
	public int getColumnCount(int sheetIndex) {
		int column = wb.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
		return column;
	}

}
