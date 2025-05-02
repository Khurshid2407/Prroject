package Organization;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import ObjectRepo.CreatingNewOrganizationPage;
import ObjectRepo.HomePage;
import ObjectRepo.OrganizationPage;

public class CreateOrgWithPhoneNoTest extends BaseClass{

	@Test(groups = "RegressionTest")
	public void createOrgWithPhoneTest() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationMenu();
		
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickOnOrganizationPlusIcon();
		
		String orgName = elib.getDataFromExcel("Organization",7,2)+jlib.getRandomNumber();
		String phoneNo = elib.getDataFromExcel("Organization",7,3);

		CreatingNewOrganizationPage createNewOrg=new CreatingNewOrganizationPage(driver);
		createNewOrg.createNewOrganization(orgName, phoneNo);
	
		String actPhone = createNewOrg.getPhoneValidation().getText();
		Assert.assertEquals(actPhone, phoneNo);
		System.out.println(actPhone+"---> Phone validation passed");
		
	}

}
