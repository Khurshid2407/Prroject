package DataDrivenTesting;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;

@Listeners(Generic_Utility.ListenerImplements.class)
public class Listener extends BaseClass{
	
	@Test(retryAnalyzer = Generic_Utility.RetryAnalyzerImplementation.class)
	public void create()
	{
		System.out.println("Creating");
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
		System.out.println("Passed");
	}
	
}
