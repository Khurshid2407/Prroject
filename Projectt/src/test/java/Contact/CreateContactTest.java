package Contact;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import ObjectRepo.ContactPage;
import ObjectRepo.CreatingNewContactPage;
import ObjectRepo.HomePage;

public class CreateContactTest extends BaseClass{
	
	@Test(groups = "SmokeTest")
	public void createContectTest() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		hp.clickOnContactMenu();
		
		ContactPage conP=new ContactPage(driver);
		conP.clickOnContactPlusIcon();
		
		String lastName = elib.getDataFromExcel("Contact", 1, 2)+jlib.getRandomNumber();
	
		CreatingNewContactPage createNewCon=new CreatingNewContactPage(driver);
		createNewCon.createNewContact(lastName);
		
		String actLastName = createNewCon.getLastNameValidation().getText();
		Assert.assertEquals(actLastName, lastName);
		System.out.println(actLastName+"--->LastName validation passed");
		
	}

}
