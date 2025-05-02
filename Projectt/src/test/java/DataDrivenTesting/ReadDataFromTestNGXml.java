package DataDrivenTesting;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromTestNGXml {
	
	@Test
	public void sampleTest(XmlTest test)
	{
		System.out.println("Executed");
		
	}

}
