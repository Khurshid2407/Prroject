package Contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import ObjectRepo.ContactPage;
import ObjectRepo.CreatingNewContactPage;
import ObjectRepo.CreatingNewOrganizationPage;
import ObjectRepo.HomePage;
import ObjectRepo.OrganizationPage;

public class CreateContactWithOrgTest extends BaseClass{

	@Test(groups = "RegressionTest")
	public void createContactWithOrgTest() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationMenu();
		
		OrganizationPage orgP=new OrganizationPage(driver);
		orgP.clickOnOrganizationPlusIcon();

		String orgName = elib.getDataFromExcel("Organization", 1, 2)+jlib.getRandomNumber();
		
		CreatingNewOrganizationPage creatNewOrg=new CreatingNewOrganizationPage(driver);
		creatNewOrg.createNewOrganization(orgName);
		
		String expectedTitle="http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=";
		
		String actOrgaName = creatNewOrg.getOrganizationNameValidate().getText();
		Assert.assertEquals(actOrgaName, orgName);
		System.out.println(actOrgaName+"--->Organization validation passed");
		
		hp.clickOnContactMenu();

		ContactPage conP=new ContactPage(driver);
		conP.clickOnContactPlusIcon();

		String lastName = elib.getDataFromExcel("Contact", 1, 2)+jlib.getRandomNumber();
		
		CreatingNewContactPage creatNewCon=new CreatingNewContactPage(driver);
		creatNewCon.createNewContactWithOutSave(lastName);
		
		creatNewCon.createNewConWithOrg();
		
		wlib.switchWindowOnTitle(driver, expectedTitle);
	
		creatNewCon.createNewConWithOrgPassOrgName(orgName);
		
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		wlib.returnParentWindow(driver);

		creatNewCon.contactSave();
	
		String actLastName = creatNewCon.getLastNameValidation().getText();
		Assert.assertEquals(actLastName, lastName);
		System.out.println(actLastName+"--->Last name validation passed");
		
		String actOrgName = driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']/a[text()='"+orgName+"']")).getText();
		Assert.assertEquals(actOrgName, orgName);
		System.out.println(actOrgName+"--->Organization validation passed");
	
	}

}
