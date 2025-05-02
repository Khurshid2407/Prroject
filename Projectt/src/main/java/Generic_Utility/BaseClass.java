package Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;

public class BaseClass {
	
	public File_Utility flib=new File_Utility();
	public Excel_Utility elib=new Excel_Utility();
	public Java_Utility jlib=new Java_Utility();
	public WebDriver_Utility wlib=new WebDriver_Utility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void dbConnection()
	{
		System.out.println("DB connection created");
	}
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome") String BROWSER) throws Throwable
	{
		//String BROWSER =flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
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
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		wlib.getMaximizeScreen(driver);
		wlib.getImplicitWait(driver);
		wlib.navigateToUrl(driver, URL);
		System.out.println("Browser launch sucessfully");
	}
	@BeforeMethod(alwaysRun = true)
	public void loginOperation() throws Throwable
	{
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToAppli(USERNAME, PASSWORD);
		System.out.println("Login done sucessfully");
	}
	@AfterMethod(alwaysRun = true)
	public void logoutOperation()
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnLogOutOperation(driver);
		System.out.println("LogOut done sucessfully");
	}
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("Browser closed sucessfully");
	}
	@AfterSuite(alwaysRun = true)
	public void closeDBConnection()
	{
		System.out.println("Close DB connection sucessfully");
	}

}
