package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "Leads")
	private WebElement LeadsMenu;
	
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationMenu;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactMenu;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AccountIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutButton;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver , this);
	}

	/**
	 * @return the leadsMenu
	 */
	public WebElement getLeadsMenu() {
		return LeadsMenu;
	}

	/**
	 * @return the organizationMenu
	 */
	public WebElement getOrganizationMenu() {
		return OrganizationMenu;
	}

	/**
	 * @return the contactMenu
	 */
	public WebElement getContactMenu() {
		return ContactMenu;
	}

	/**
	 * @return the accountIcon
	 */
	public WebElement getAccountIcon() {
		return AccountIcon;
	}

	/**
	 * @return the signOutButton
	 */
	public WebElement getSignOutButton() {
		return SignOutButton;
	}
	
	public void clickOnLeadsMenu()
	{
		getLeadsMenu().click();
	}
	
	public void clickOnOrganizationMenu()
	{
		getOrganizationMenu().click();
	}
	
	public void clickOnContactMenu()
	{
		getContactMenu().click();
	}
	
	public void clickOnLogOutOperation(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(getAccountIcon()).perform();
		act.click(getSignOutButton()).perform();
		driver.quit();
	}

	
}
