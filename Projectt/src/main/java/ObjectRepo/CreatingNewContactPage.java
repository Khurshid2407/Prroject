package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {

	@FindBy(name = "lastname")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@name='account_name']/..//img[@alt='Select']")
	private WebElement orgNameSearch;
	
	@FindBy(id = "search_txt")
	private WebElement orgSearching;
	
	@FindBy(name = "search")
	private WebElement searchOrg;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "mobile")
	private WebElement phone;
	
	@FindBy(name = "support_start_date")
	private WebElement startDate;
	
	@FindBy(name = "support_end_date")
	private WebElement endDate;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement lastNameValidation;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startDateValidation;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement endDateValidation;
	
	@FindBy(id = "mouseArea_Email")
	private WebElement emailValidation;
	
	@FindBy(id = "mouseArea_Mobile")
	private WebElement mobileValidation;
	
	public CreatingNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	/**
	 * @return the lastName
	 */
	public WebElement getLastName() {
		return lastName;
	}

	/**
	 * @return the orgName
	 */
	public WebElement getOrgNameSearch() {
		return orgNameSearch;
	}
	
	/**
	 * @return the orgSearching
	 */
	public WebElement getOrgSearching() {
		return orgSearching;
	}

	/**
	 * @return the searchOrg
	 */
	public WebElement getSearchOrg() {
		return searchOrg;
	}

	/**
	 * @return the email
	 */
	public WebElement getEmail() {
		return email;
	}

	/**
	 * @return the phone
	 */
	public WebElement getPhone() {
		return phone;
	}
	
	/**
	 * @return the startDate
	 */
	public WebElement getStartDate() {
		return startDate;
	}

	/**
	 * @return the endDate
	 */
	public WebElement getEndDate() {
		return endDate;
	}

	/**
	 * @return the saveButton
	 */
	public WebElement getSaveButton() {
		return saveButton;
	}

	/**
	 * @return the lastNameValidation
	 */
	public WebElement getLastNameValidation() {
		return lastNameValidation;
	}

	/**
	 * @return the startDateValidation
	 */
	public WebElement getStartDateValidation() {
		return startDateValidation;
	}

	/**
	 * @return the endDateValidation
	 */
	public WebElement getEndDateValidation() {
		return endDateValidation;
	}

	/**
	 * @return the emailValidation
	 */
	public WebElement getEmailValidation() {
		return emailValidation;
	}

	/**
	 * @return the mobileValidation
	 */
	public WebElement getMobileValidation() {
		return mobileValidation;
	}

	public void createNewContact(String lastName)
	{
		getLastName().sendKeys(lastName);
		getSaveButton().click();
	}
	
	public void createNewContactWithOutSave(String lastName)
	{
		getLastName().sendKeys(lastName);
	}
	
	public void createNewConWithOrg()
	{
		getOrgNameSearch().click();
	}
	
	public void createNewConWithOrgPassOrgName(String orgName)
	{
		getOrgSearching().sendKeys(orgName);
		getSearchOrg().click();
		
	}
	
	public void createNewContact(String lastName , String email , String phone)
	{
		getLastName().sendKeys(lastName);
		getEmail().sendKeys(email);
		getPhone().sendKeys(phone);
		getSaveButton().click();
	}
	
	public void createNewContactWithDate(String lastName , String startDate , String endDate)
	{
		getLastName().sendKeys(lastName);
		getStartDate().clear();
		getStartDate().sendKeys(startDate);
		getEndDate().clear();
		getEndDate().sendKeys(endDate);
		getSaveButton().click();
	}
	
	public void contactSave()
	{
		getSaveButton().click();
	}
	
}
