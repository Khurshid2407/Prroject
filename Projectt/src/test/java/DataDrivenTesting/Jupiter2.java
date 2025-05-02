package DataDrivenTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jupiter2 {

	public static void main(String[] args) {
		
		String expectedData="Thanks";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://jupiter.cloud.planittesting.com/");
		driver.findElement(By.xpath("//a[text()='Contact']")).click();
		driver.findElement(By.id("forename")).sendKeys("Khan");
		driver.findElement(By.id("email")).sendKeys("khan@gmail.com");
		driver.findElement(By.id("message")).sendKeys("Nice Toys");
		driver.findElement(By.xpath("//a[text()='Submit']")).click();
		String doneMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		if(doneMsg.contains(expectedData))
		{
			System.out.println("Validation sucessfull");
		}
		else
		{
			System.out.println("Validation failed");
		}

	}

}
