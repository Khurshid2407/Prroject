package Organization;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import ObjectRepo.CreatingNewOrganizationPage;
import ObjectRepo.HomePage;
import ObjectRepo.OrganizationPage;

public class CreateOrganizationWithEmpTest extends BaseClass{

	@Test(groups = {"SmokeTest","RegressionTest"})
	public void createOrgWithEmpTest() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationMenu();
		
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickOnOrganizationPlusIcon();
		
		String orgName = elib.getDataFromExcel("Organization", 10, 2)+jlib.getRandomNumber();
		String noOfEmp = elib.getDataFromExcel("Organization", 10, 3);
		
		CreatingNewOrganizationPage createNewOrg=new CreatingNewOrganizationPage(driver);
		createNewOrg.createNewOrganizationWithEmp(orgName, noOfEmp);
	
		String actEmp = createNewOrg.getEmployeeValidation().getText();
		Assert.assertTrue(actEmp.contains(noOfEmp));
		System.out.println(actEmp+"---> Employee validation passed");

	}

}
