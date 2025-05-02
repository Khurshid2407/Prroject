package Generic_Utility;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriver_Utility {
	
	String parentWin;
	
	public void getMaximizeScreen(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void getImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void getExplicitWait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void navigateToUrl(WebDriver driver , String Url)
	{
		driver.get(Url);
	}
	
	public void selectOptionByIndex(WebElement dropdownElement, int index)
	{
		Select sel=new Select(dropdownElement);
		sel.selectByIndex(index);
	}
	
	public void selectOptionByValue(WebElement dropdownElement, String value)
	{
		Select sel=new Select(dropdownElement);
		sel.selectByValue(value);
	}
	
	public void selectOptionByVisibleText(WebElement dropdownElement, String text)
	{
		Select sel=new Select(dropdownElement);
		sel.selectByVisibleText(text);
	}
	
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void moveToElementAndClick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement dragEle,WebElement dropEle)
	{
		Actions act =new Actions(driver);
		act.dragAndDrop(dragEle, dropEle).perform();
	}
	
	public void scrollToElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	public void sendKeys(WebDriver driver, String value)
	{
		Actions act=new Actions(driver);
		act.sendKeys(value).perform();
	}
	
	public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest =new File("./Screenshot/"+screenshotName+".png");
		Files.copy(src, dest);
	}
	
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void alertCancle(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void getAlertMessage(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	
	public void sendAlertMessage(WebDriver driver , String value)
	{
		driver.switchTo().alert().sendKeys(value);
	}
	
	public void switchWindowOnURL(WebDriver driver, String particularURL)
	{
		parentWin = driver.getWindowHandle();
		Set<String> allWin = driver.getWindowHandles();
		for(String id:allWin)
		{
			if(id!=parentWin)
			{
				driver.switchTo().window(id);
				String actUrl = driver.getCurrentUrl();
				if(actUrl.contains(particularURL))
				{
					break;
				}
			}
		}
	}
	
	public void switchWindowOnTitle(WebDriver driver, String partialTitle)
	{
		parentWin = driver.getWindowHandle();
		Set<String> allWin = driver.getWindowHandles();
		for(String id:allWin)
		{
			if(id!=parentWin)
			{
				driver.switchTo().window(id);
				String actUrl = driver.getTitle();
				if(actUrl.contains(partialTitle))
				{
					break;
				}
			}
		}
	}
	
	public void returnParentWindow(WebDriver driver)
	{
		driver.switchTo().window(parentWin);
	}
	
	public void javaScriptSendData(WebDriver driver , WebElement element,String value)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].value='"+value+"';", element);
	}
	

}
