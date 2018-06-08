package com.Bugfinders.excel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcelFile {

	
	public static Object[][] readExcelData(String SheetName) throws IOException {
		// TODO Auto-generated method stub
			FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\com\\Bugfinders\\Resources\\BugFindersTestData.xlsx"));		
			XSSFWorkbook wbook = new XSSFWorkbook(fis);
			XSSFSheet sheet=wbook.getSheet(SheetName);
			XSSFRow row = null;
			XSSFCell cel = null;
			Map<String, Object> map = null;
			
			row = sheet.getRow(0);
			String[] header = new String[row.getLastCellNum()];
			Object[][] data = new Object[sheet.getLastRowNum()][1];
			
			for (int r=row.getFirstCellNum();r<row.getLastCellNum();r++)
			{
				header[r]= row.getCell(r).getStringCellValue();
				
				//System.out.println(header[r]);
			}
			for (int i =sheet.getFirstRowNum()+1;i<=sheet.getLastRowNum();i++)
			{
				row = sheet.getRow(i);
				map = new LinkedHashMap<String, Object>();
				
				for (int j=row.getFirstCellNum();j<row.getLastCellNum();j++)
				{
					cel = row.getCell(j);
					switch (cel.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						map.put(header[j], cel.getNumericCellValue());
						break;					
					case Cell.CELL_TYPE_STRING:
						map.put(header[j], cel.getStringCellValue());
						break;
					default:
						break;
					}
					//System.out.println(map.get("Option"));
				}
				data[i-1][0]=map;
			}			

		return data;
	}
/*public static void main(String[] args) throws IOException {
	readExcelFile.readExcelData();
}*/
}
