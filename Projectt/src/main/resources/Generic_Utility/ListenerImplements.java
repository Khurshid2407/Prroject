package Generic_Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplements implements ITestListener , ISuiteListener{
	
	public static ExtentReports report;
	public static ExtentTest test;
	public Java_Utility jlib=new Java_Utility();
	
	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("OnFinish ISuite"+"--->Report backup");
		report.flush();
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("OnStart ISuite"+"--->Report configuration");
		String dateStamp = jlib.getCalendarDetails("dd-MM-YYY hh-mm-ss");
		ExtentSparkReporter spark=new ExtentSparkReporter("/TekPyramid/AdvanceReport/Report- "+dateStamp+" .html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Repoter Name", "Khurshid Alam");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onFinish");
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onStart");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailedWithTimeout");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Java_Utility jlib=new Java_Utility();
		String dateTime = jlib.getCalendarDetails("dd-MM-YYY hh-mm-ss");
		String testName = result.getMethod().getMethodName();
		
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath,testName+"_"+dateTime);
		test.log(Status.FAIL,result.getMethod().getMethodName()+"---> Failed <---");
		test.log(Status.FAIL,result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSkipped");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("<-------"+result.getMethod().getMethodName()+"----START---->");
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"---> Started <---");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("<-------"+result.getMethod().getMethodName()+"----END---->");
		test.log(Status.PASS, result.getMethod().getMethodName()+"---> Completed <---");
	}
	
}
