package DataDrivenTesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis=new FileInputStream("./data/ExcelFile1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Mobile Details");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(0);
		System.out.println(cell.getStringCellValue());
		wb.close();
	}

}
