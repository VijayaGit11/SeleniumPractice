package com.qa.testCases;

import org.testng.annotations.Test;

import com.qa.util.ReadExcelData;

public class excelDataTestCase {
	
	@Test
	public void getDatafromExcel() {
	ReadExcelData excel = new ReadExcelData("C:/Users/HP/Documents/Framework/SeleniumPractice/src/main/java/testData/TestData.xlsx");
	System.out.println(excel.getData(0, 0, 0));
	}

}
