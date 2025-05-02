package StepsToCreateFrameWork;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import ObjectRepo.CreatingNewOrganizationPage;
import ObjectRepo.HomePage;
import ObjectRepo.OrganizationPage;

public class Till_BaseClass extends BaseClass{
	
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
		
		String indusValidate = driver.findElement(By.id("dtlview_Industry")).getText();
		if(indusValidate.equals(industries))
		{
			System.out.println(industries+" dropdown validation passed");
		}
		else 
		{
			System.out.println(industries+" dropdown validation failed");
		}
		
		String typeValidate = driver.findElement(By.id("dtlview_Type")).getText();
		if(typeValidate.equals(type))
		{
			System.out.println(typeValidate+" dropdown validation passed");
		}
		else 
		{
			System.out.println(typeValidate+" dropdownvalidation failed");
		}
	}	
}
