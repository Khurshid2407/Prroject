package Generic_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
	
	public String getDataFromPropertiesFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("/TekPyramid/src/main/resources/CommonData/VTigerCommonData.propertyes");
		Properties pro=new Properties();
		pro.load(fis);
		String data = pro.getProperty(key);
		return data;
	}

}
