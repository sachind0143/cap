package com.flightbooking.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;


public class ExcelUtils {
public static Object[][] getExcelData(String path,String sheetName)throws IOException{
	FileInputStream fis = new FileInputStream(path);
	
	Workbook workbook= WorkbookFactory.create(fis);
	Sheet sheet= workbook.getSheet(sheetName);
	int rowCount= sheet.getPhysicalNumberOfRows();
	int colCount= sheet.getRow(0).getPhysicalNumberOfCells();
	
	Object[][] data= new Object[rowCount-1][colCount];
	DataFormatter formatter =new DataFormatter();
	for(int i=1; i < rowCount; i++)
	{
		Row row = sheet.getRow(i);
		for(int j=0; j <colCount; j++)
		{	
			Cell cell = row.getCell(j,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			
			data[i-1][j]= formatter.formatCellValue(cell);
		}
	}
	workbook.close();
	return data;
}
}
