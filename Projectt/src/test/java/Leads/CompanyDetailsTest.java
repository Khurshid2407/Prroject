package Leads;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import ObjectRepo.CreatingNewLeadPage;
import ObjectRepo.HomePage;
import ObjectRepo.LeadPage;

public class CompanyDetailsTest extends BaseClass{

	@Test(groups = "RegressionTest")
	public void companyDetailsTest() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsMenu();
	
		LeadPage leadP=new LeadPage(driver);
		leadP.clickOnLeadPlusIcon();
	
		String lastName = elib.getDataFromExcel("LeadsModule", 10, 2)+jlib.getRandomNumber();
		String company = elib.getDataFromExcel("LeadsModule", 10, 3);
		String city = elib.getDataFromExcel("LeadsModule", 10, 4);
		String state = elib.getDataFromExcel("LeadsModule", 10, 5);
		
		CreatingNewLeadPage createNewLeadPag=new CreatingNewLeadPage(driver);
		createNewLeadPag.createNewLeadWithAddress(lastName, company, city, state);
		
		String actCity = createNewLeadPag.getCityValidation().getText();
		Assert.assertTrue(actCity.contains(city));
		System.out.println(actCity+"--->City validation passed");
		
		String actState = createNewLeadPag.getStateValidation().getText();
		Assert.assertTrue(actState.contains(state));
		System.out.println(actState+"--->State validation passed");
	
	}

}
