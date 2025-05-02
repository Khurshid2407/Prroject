package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis =new FileInputStream("./data/ExcelFile1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Mobile Details");
		sh.getRow(1).createCell(3).setCellValue("Hii");
		FileOutputStream fos=new FileOutputStream("./data/ExcelFile1.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("Executed");

	}

}
