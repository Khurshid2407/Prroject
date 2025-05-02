package Contact;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import ObjectRepo.ContactPage;
import ObjectRepo.CreatingNewContactPage;
import ObjectRepo.HomePage;

public class CreateContactWithSupportDateTest extends BaseClass{

	@Test(groups = "RegressionTest")
	public void createContactWithSupportDateTest() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		hp.clickOnContactMenu();
	
		ContactPage conP=new ContactPage(driver);
		conP.clickOnContactPlusIcon();
		
		String startDate = jlib.getSystemDateYYYYMMDD();
		String endDate = jlib.getRequiredDateYYYYMMDD(30);
		
		String lastName = elib.getDataFromExcel("Contact", 4, 2)+jlib.getRandomNumber();
		
		CreatingNewContactPage createNewCon=new CreatingNewContactPage(driver);
		createNewCon.createNewContactWithDate(lastName, startDate, endDate);
		
		String actStartDate = createNewCon.getStartDateValidation().getText();
		Assert.assertEquals(actStartDate, startDate);
		System.out.println(actStartDate+"--->Start date validation passed");
		
		String actEndDate = createNewCon.getEndDateValidation().getText();
		Assert.assertEquals(actEndDate, endDate);
		System.out.println(actEndDate+"--->End date validation passed");
		
	}

}
