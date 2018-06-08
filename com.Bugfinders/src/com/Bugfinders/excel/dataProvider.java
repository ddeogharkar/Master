package com.Bugfinders.excel;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataProvider {
	
	@DataProvider(name="TC1")
	public static Object[][] TC1() throws IOException {
		return readExcelFile.readExcelData("TC1");
	}
	
	@DataProvider(name="TC2")
	public static Object[][] TC2() throws IOException {
		return readExcelFile.readExcelData("TC2");
	}
	
	@DataProvider(name="TC3")
	public static Object[][] TC3() throws IOException {
		return readExcelFile.readExcelData("TC3");
	}
	
	@DataProvider(name="TC4")
	public static Object[][] TC4() throws IOException {
		return readExcelFile.readExcelData("TC4");
	}

}
