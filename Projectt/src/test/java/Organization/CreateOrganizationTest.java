package Organization;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Generic_Utility.BaseClass;
import Generic_Utility.UtilityClassObject;
import ObjectRepo.CreatingNewOrganizationPage;
import ObjectRepo.HomePage;
import ObjectRepo.OrganizationPage;

@Listeners(Generic_Utility.ListenerImplements.class)
public class CreateOrganizationTest extends BaseClass{

	@Test(groups = "SmokeTest")
	public void createOrgTest() throws Throwable
	{	
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org Page");
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationMenu();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnOrganizationPlusIcon();
		
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String orgName = elib.getDataFromExcel("Organization", 1, 2)+jlib.getRandomNumber();
		
		CreatingNewOrganizationPage newOrg =new CreatingNewOrganizationPage(driver);
		newOrg.createNewOrganization(orgName);
	
		String header = newOrg.getOrganizationHeaderValidate().getText();
		Assert.assertTrue(header.contains(orgName));
		System.out.println(header+"---> Header Validation Passed");
		
		String actName = newOrg.getOrganizationNameValidate().getText();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actName, orgName);
		System.out.println(actName+"---> Name Validation Passed");
		sa.assertAll();	
	}
	
}
