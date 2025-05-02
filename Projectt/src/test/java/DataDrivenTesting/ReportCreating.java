package DataDrivenTesting;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ReportCreating {
	
	@Test
	public void createContactTest()
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("/TekPyramid/AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "Chrome");
		ExtentTest test = report.createTest("createContactTest");
		
		test.log(Status.INFO,"login to app.");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC"))
		{
			test.log(Status.PASS, "Contact is created");
		}
		else
		{
			test.log(Status.FAIL,"Contact is not created");
		}
		report.flush();
	}

}
