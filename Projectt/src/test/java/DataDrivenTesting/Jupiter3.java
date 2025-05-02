package DataDrivenTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jupiter3 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://jupiter.cloud.planittesting.com/");
		driver.findElement(By.xpath("//a[text()='Shop']")).click();
		WebElement stuffedFog = driver.findElement(By.xpath("//h4[text()='Stuffed Frog']/../p/a[text()='Buy']"));
		for(int i=1;i<=2;i++)
		{
			stuffedFog.click();
		}
		WebElement fluffyBunny = driver.findElement(By.xpath("//h4[text()='Fluffy Bunny']/../p/a[text()='Buy']"));
		for(int i=1;i<=5;i++)
		{
			fluffyBunny.click();
		}
		WebElement valentineBear = driver.findElement(By.xpath("//h4[text()='Valentine Bear']/../p/a[text()='Buy']"));
		for(int i=1;i<=3;i++)
		{
			valentineBear.click();
		}
		driver.findElement(By.xpath("//a[@href='#/cart']")).click();
		String totalRate = driver.findElement(By.xpath("//strong[text()='Total: 116.9']")).getText();
		System.out.println(totalRate);
		String rate = driver.findElement(By.xpath("//td[text()='$10.99']")).getText();
		System.out.println("Stuffed Fog --->"+rate);
		String fluffyRate = driver.findElement(By.xpath("//td[text()='$49.95']")).getText();
		System.out.println("Fluffy Bunny --->"+fluffyRate);
		String valentineBearRate = driver.findElement(By.xpath("//td[text()='$44.97']")).getText();
		System.out.println("Valentine Bear --->"+valentineBearRate);
		driver.close();
		
		
	}

}
