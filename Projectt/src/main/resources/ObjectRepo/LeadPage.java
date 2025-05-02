package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {
	
	@FindBy(xpath = "//img[@alt='Create Lead...']")
	private WebElement leadPlusIcon;
	
	public LeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	/**
	 * @return the leadPlusIcon
	 */
	public WebElement getLeadPlusIcon() {
		return leadPlusIcon;
	}
	
	public void clickOnLeadPlusIcon()
	{
		getLeadPlusIcon().click();
	}

}
