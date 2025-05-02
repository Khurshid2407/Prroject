package Generic_Utility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON_Utility {
	
	public String getDataFromJsonFile(String key) throws Throwable, Throwable, ParseException
	{
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("/TekPyramid/src/test/resources/TestData/jsonData.JSON"));
		JSONObject jb=(JSONObject)obj;
		String data = (String)jb.get(key);
		return data;
		 
	}
	
}
