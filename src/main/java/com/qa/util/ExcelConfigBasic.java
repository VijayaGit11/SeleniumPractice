package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelConfigBasic {
	
	File src = new File("C:/Users/HP/Documents/Framework/SeleniumPractice/src/main/java/testData/TestData.xlsx");
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	@Test
	public void readExcel() throws Exception {
		
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("Sheet1");
		
		String data =sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println("data from row 0 is "+ data);
		
		System.out.println("Total number of rows are "+ sheet.getLastRowNum());

		for (int i=0; i<sheet.getLastRowNum(); i++) {
			System.out.println("Data from excel row is  "+ sheet.getRow(i).getCell(0).getStringCellValue());
			System.out.println("data from row " + i + " is "+sheet.getRow(i).getCell(0).getStringCellValue());
		}
			wb.close();
		}
	
	@Test
	public void writeExcelData() throws Exception {

		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
		sheet.getRow(0).createCell(2).setCellValue("Status");
		sheet.getRow(1).createCell(2).setCellValue("Pass");
		sheet.getRow(2).createCell(2).setCellValue("Fail");
		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);
		wb.close();
	}
	
	
}
