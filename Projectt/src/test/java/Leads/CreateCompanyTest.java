package Leads;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import ObjectRepo.CreatingNewLeadPage;
import ObjectRepo.HomePage;
import ObjectRepo.LeadPage;

public class CreateCompanyTest extends BaseClass{

	@Test(groups = "SmokeTest")
	public void createCompanyTest() throws Throwable {
	
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsMenu();
		
		LeadPage leadP=new LeadPage(driver);
		leadP.clickOnLeadPlusIcon();
	
		String lastName = elib.getDataFromExcel("LeadsModule", 1, 2)+jlib.getRandomNumber();
		String company = elib.getDataFromExcel("LeadsModule", 1, 3);
		
		CreatingNewLeadPage createNewLead=new CreatingNewLeadPage(driver);
		createNewLead.createNewLead(lastName, company);
		
		String actLastName = createNewLead.getLastNameValidation().getText();
		Assert.assertTrue(actLastName.contains(lastName));
		System.out.println(actLastName+"--->LastName validation passed");
	
		String actCompany = createNewLead.getCompanyValidation().getText();
		Assert.assertTrue(actCompany.contains(company));
		System.out.println(actCompany+"--->Company validation passed");
		
	}
	
}
