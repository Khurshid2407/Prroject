package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement contactPlusIcon;
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	/**
	 * @return the contactPlusIcon
	 */
	public WebElement getContactPlusIcon() {
		return contactPlusIcon;
	}
	
	public void clickOnContactPlusIcon()
	{
		getContactPlusIcon().click();
	}

}
