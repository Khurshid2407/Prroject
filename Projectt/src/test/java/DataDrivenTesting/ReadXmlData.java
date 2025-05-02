package DataDrivenTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import Generic_Utility.WebDriver_Utility;

public class ReadXmlData {
	
	
	@Test
	public void createOrgTest(XmlTest test)
	{
		String BROWSER = test.getParameter("browser");
		String URL = test.getParameter("url");
		String UESRNAME = test.getParameter("username");
		String PASSWORD = test.getParameter("password");
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		
		WebDriver driver;
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		wlib.getMaximizeScreen(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UESRNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	}

}
