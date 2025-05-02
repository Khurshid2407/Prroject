package DataDrivenTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrame {

	public static void main(String[] args) throws Exception {
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		 driver.findElement(By.xpath("//section[text()='Frames']")).click();
		 driver.findElement(By.linkText("iframes")).click();
		 driver.findElement(By.linkText("Multiple iframe")).click();
		 Thread.sleep(3000);
		 driver.switchTo().frame(0);
		 driver.findElement(By.id("email")).sendKeys("khurshid@gmail.com");
		 driver.findElement(By.id("password")).sendKeys("khurshid123");
		 driver.findElement(By.id("confirm-password")).sendKeys("khurshid123");
		 driver.findElement(By.id("submitButton")).click();
		 driver.switchTo().defaultContent();
		 Thread.sleep(3000);
		 driver.switchTo().frame(1);
		 driver.findElement(By.id("username")).sendKeys("khurshid0786");
		 driver.findElement(By.id("password")).sendKeys("khurshid123");
		 driver.findElement(By.id("submitButton")).click(); 

	}

}
