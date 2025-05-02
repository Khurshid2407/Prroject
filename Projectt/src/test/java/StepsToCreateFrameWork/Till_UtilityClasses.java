package StepsToCreateFrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;

public class Till_UtilityClasses {

	public static void main(String[] args) throws Throwable {
		
		File_Utility flib=new File_Utility();
		Excel_Utility elib=new Excel_Utility();
		Java_Utility jlib=new Java_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		
		String orgName = elib.getDataFromExcel("Organization", 4, 2)+jlib.getRandomNumber();
		String industries = elib.getDataFromExcel("Organization", 4, 3);
		String type = elib.getDataFromExcel("Organization", 4, 4);
		
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
		wlib.getImplicitWait(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		WebElement industry = driver.findElement(By.name("industry"));
		wlib.selectOptionByVisibleText(industry, industries);
		
		WebElement types = driver.findElement(By.name("accounttype"));
		wlib.selectOptionByValue(types, type);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String indusValidate = driver.findElement(By.id("dtlview_Industry")).getText();
		if(indusValidate.equals(industries))
		{
			System.out.println(industries+" dropdown validation passed");
		}
		else 
		{
			System.out.println(industries+" dropdown validation failed");
		}
		
		String typeValidate = driver.findElement(By.id("dtlview_Type")).getText();
		if(typeValidate.equals(type))
		{
			System.out.println(typeValidate+" dropdown validation passed");
		}
		else 
		{
			System.out.println(typeValidate+" dropdownvalidation failed");
		}
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

}
