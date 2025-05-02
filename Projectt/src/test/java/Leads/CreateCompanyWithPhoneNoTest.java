package Leads;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utility.BaseClass;
import ObjectRepo.CreatingNewLeadPage;
import ObjectRepo.HomePage;
import ObjectRepo.LeadPage;

public class CreateCompanyWithPhoneNoTest extends BaseClass{

	@Test(groups = {"SmokeTest","RegressionTest"})
	public void createCompWithPhoneNoTest() throws Throwable {
	
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsMenu();
	
		LeadPage leadP=new LeadPage(driver);
		leadP.clickOnLeadPlusIcon();
	
		String lastName = elib.getDataFromExcel("LeadsModule", 4, 2)+jlib.getRandomNumber();
		String company = elib.getDataFromExcel("LeadsModule", 4, 3);
		String phone = elib.getDataFromExcel("LeadsModule", 4, 4);
		String email = elib.getDataFromExcel("LeadsModule", 4, 5);
		
		CreatingNewLeadPage creatNewLeadPag=new CreatingNewLeadPage(driver);
		creatNewLeadPag.createNewLead(lastName, company, phone, email);
		
		String actPhone = creatNewLeadPag.getPhoneValidation().getText();
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(actPhone.contains(phone));
		System.out.println(actPhone+"--->Phone validation passed");
		
		String actEmail = creatNewLeadPag.getEmailValidation().getText();
		sa.assertTrue(actEmail.contains(email));
		System.out.println(actEmail+"--->Email validation passed");
		sa.assertAll();
	}
}
