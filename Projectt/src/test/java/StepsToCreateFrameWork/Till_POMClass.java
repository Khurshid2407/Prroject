package StepsToCreateFrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import ObjectRepo.CreatingNewOrganizationPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import ObjectRepo.OrganizationPage;

public class Till_POMClass {

	public static void main(String[] args) throws Throwable {
		
		File_Utility flib=new File_Utility();
		Excel_Utility elib=new Excel_Utility();
		Java_Utility jlib=new Java_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		
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
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToAppli(USERNAME, PASSWORD);
	
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationMenu();
		
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickOnOrganizationPlusIcon();
		
		String orgName = elib.getDataFromExcel("Organization", 4, 2)+jlib.getRandomNumber();
		String industries = elib.getDataFromExcel("Organization", 4, 3);
		String type = elib.getDataFromExcel("Organization", 4, 4);
		
		CreatingNewOrganizationPage createOrg=new CreatingNewOrganizationPage(driver);
		createOrg.createNewOrganization(orgName, industries, type);
		
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
		
		hp.clickOnLogOutOperation(driver);
		

	}

}
