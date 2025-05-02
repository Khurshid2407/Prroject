package DataDrivenTesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleRowData {

	public static void main(String[] args) throws Exception {
	
		FileInputStream fis=new FileInputStream("./data/ExcelFile1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Mobile Details");
		int rowCount = sheet.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++)
		{
			Row row = sheet.getRow(i);
			String data1 = row.getCell(0).toString();
			String data2 = row.getCell(1).toString();
			String data3 = row.getCell(2).toString();
			System.out.println(data1+"----->"+data2+"----->"+data3);
		}
		wb.close();

	}

}
