package StepsToCreateFrameWork;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import ObjectRepo.CreatingNewOrganizationPage;
import ObjectRepo.HomePage;
import ObjectRepo.OrganizationPage;

public class Till_Assertion extends BaseClass{
	
	@Test(groups = "SmokeTest")
	public void createOrgWithTypeTest() throws Throwable {
	
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationMenu();
		
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickOnOrganizationPlusIcon();
		
		String orgName = elib.getDataFromExcel("Organization", 4, 2)+jlib.getRandomNumber();
		String industries = elib.getDataFromExcel("Organization", 4, 3);
		String type = elib.getDataFromExcel("Organization", 4, 4);
		
		CreatingNewOrganizationPage createOrg=new CreatingNewOrganizationPage(driver);
		createOrg.createNewOrganization(orgName, industries, type);
		
		String actIndustry = createOrg.getIndustryValidation().getText();
		Assert.assertTrue(actIndustry.contains(industries));
		System.out.println(actIndustry+"---> Industry validation passed");
		
		String actType = createOrg.getTypeValidation().getText();
		Assert.assertTrue(actType.contains(type));
		System.out.println(actType+"---> Type validation passed");
	}

}
