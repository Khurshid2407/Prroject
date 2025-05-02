package Contact;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import ObjectRepo.ContactPage;
import ObjectRepo.CreatingNewContactPage;
import ObjectRepo.HomePage;

public class CreateContactWithEmailTest extends BaseClass{

	@Test(groups = {"SmokeTest","RegressionTest"})
	public void createContactWithEmailTest() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		hp.clickOnContactMenu();

		ContactPage conP=new ContactPage(driver);
		conP.clickOnContactPlusIcon();

		String lastName = elib.getDataFromExcel("Contact", 10, 2)+jlib.getRandomNumber();
		String email = elib.getDataFromExcel("Contact", 10, 3);
		String phone = elib.getDataFromExcel("Contact", 10, 4);
		
		CreatingNewContactPage createNewCon=new CreatingNewContactPage(driver);
		createNewCon.createNewContact(lastName, email, phone);
		
		String actEmail = createNewCon.getEmailValidation().getText();
		Assert.assertEquals(actEmail, email);
		System.out.println(actEmail+"--->Email validation passed");
	
		String actMobile = createNewCon.getMobileValidation().getText();
		Assert.assertTrue(actMobile.contains(phone));
		System.out.println(actMobile+"--->Mobile validation passed");
	}	
}
