package DataDrivenTesting;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSONFile {

	public static void main(String[] args) throws Exception, IOException, ParseException {
	
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("./jsonData.JSON"));
		JSONObject jb=(JSONObject)obj;
		System.out.println(jb.get("url"));
		System.out.println(jb.get("username"));
		System.out.println("browser");

	}

}
