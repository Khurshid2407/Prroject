package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	public String getDataFromExcel(String sheetName,int row,int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream("/TekPyramid/src/test/resources/TestData/NAANA PATEKAR.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		return data;
	}
	
	public int getRowcount(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream("/TekPyramid/src/test/resources/TestData/NAANA PATEKAR.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	public void setDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream("/TekPyramid/src/test/resources/TestData/NAANA PATEKAR.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		
		FileOutputStream fos=new FileOutputStream("/TekPyramid/src/test/resources/TestData/NAANA PATEKAR.xlsx");
		wb.write(fos);
		wb.close();
	}

}
