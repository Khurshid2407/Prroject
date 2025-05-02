package DataDrivenTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jupiter {

	public static void main(String[] args) throws Throwable { 
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://jupiter.cloud.planittesting.com/");
		driver.findElement(By.xpath("//a[text()='Contact']")).click();
		driver.findElement(By.xpath("//a[text()='Submit']")).click();
		String errorMsg = driver.findElement(By.xpath("//div[@class='alert alert-error ng-scope']")).getText();
		System.out.println(errorMsg);
		driver.findElement(By.id("forename")).sendKeys("Pathan");
		driver.findElement(By.id("email")).sendKeys("pathan@gmail.com");
		driver.findElement(By.id("message")).sendKeys("Expesnsive toys");
		driver.findElement(By.xpath("//a[text()='Submit']")).click();
		Thread.sleep(5000);
		String afterFilled = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		System.out.println(afterFilled);
		if(afterFilled.equals(errorMsg))
		{
			System.out.println("Error is not handled by user");
		}
		else
		{
			System.out.println("Error is handled by user");
		}
		
	}

}
