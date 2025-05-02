package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition {

	public static void main(String[] args) throws Exception {
	
		String expectedData="Apple";
		String data1="";
		String data2="";
		String data3="";
		boolean flag=false;
		FileInputStream fis=new FileInputStream("./data/ExcelFile1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Mobile Details");
		int rowCount = sh.getLastRowNum();
		for(int i=0;i<=rowCount;i++)
		{
			String data="";
			try {
				data = sh.getRow(i).getCell(0).toString();
				if(data.contains(expectedData)) {
					flag=true;
					data1 = sh.getRow(i).getCell(0).toString();
					data2 = sh.getRow(i).getCell(1).toString();
					data3 = sh.getRow(i).getCell(2).toString();
				}
			}catch (Exception e) {
			}
		}
		if(flag==true)
		{
			System.out.println(data1+"\t"+data2+"\t"+data3);
			
		}
		else {
			System.out.println(expectedData+" is not present");
		}
		wb.close();
	}

}
