package Leads;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import ObjectRepo.CreatingNewLeadPage;
import ObjectRepo.HomePage;
import ObjectRepo.LeadPage;

public class CreateCompanyWithNoOfEmpTest extends BaseClass{

	@Test(groups = "SmokeTest")
	public void createCompWithEmpNoTest() throws Throwable {
	
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsMenu();
	
		LeadPage leadP=new LeadPage(driver);
		leadP.clickOnLeadPlusIcon();
	
		String lastName = elib.getDataFromExcel("LeadsModule", 7, 2)+jlib.getRandomNumber();
		String company = elib.getDataFromExcel("LeadsModule", 7, 3);
		String noOfEmp = elib.getDataFromExcel("LeadsModule", 7, 4);
		
		CreatingNewLeadPage creatNewLeadPag=new CreatingNewLeadPage(driver);
		creatNewLeadPag.createNewLead(lastName, company, noOfEmp);
	
		String actEmpNum = creatNewLeadPag.getEmployeeValidation().getText();
		Assert.assertTrue(actEmpNum.contains(noOfEmp));
		System.out.println(actEmpNum+"--->No.Of emp validation passed");
		
	}

}
