package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement OrganizationPlusIcon;
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	/**
	 * @return the organizationPlusIcon
	 */
	public WebElement getOrganizationPlusIcon() {
		return OrganizationPlusIcon;
	}
	
	public void clickOnOrganizationPlusIcon()
	{
		getOrganizationPlusIcon().click();
	}
	
}
