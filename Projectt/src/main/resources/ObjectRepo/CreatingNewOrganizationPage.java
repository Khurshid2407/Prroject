package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {

	@FindBy(name = "accountname")
	private WebElement organizationName;
	
	@FindBy(id = "employees")
	private WebElement noOfEmployees;
	
	@FindBy(name = "industry")
	private WebElement industryList;
	
	@FindBy(name = "accounttype")
	private WebElement typeList;
	
	@FindBy(id = "phone")
	private WebElement phone;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationHeaderValidate;
	
	@FindBy(id  = "dtlview_Organization Name")
	private WebElement organizationNameValidate;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industryValidation;
	
	@FindBy(id = "dtlview_Type")
	private WebElement typeValidation;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement phoneValidation;
	
	@FindBy(id = "mouseArea_Employees")
	private WebElement employeeValidation;
	
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	/**
	 * @return the organizationName
	 */
	public WebElement getOrganizationName() {
		return organizationName;
	}

	/**
	 * @return the noOfEmployees
	 */
	public WebElement getNoOfEmployees() {
		return noOfEmployees;
	}

	/**
	 * @return the industryList
	 */
	public WebElement getIndustryList() {
		return industryList;
	}

	/**
	 * @return the typeList
	 */
	public WebElement getTypeList() {
		return typeList;
	}

	/**
	 * @return the phone
	 */
	public WebElement getPhone() {
		return phone;
	}
	
	/**
	 * @return the save
	 */
	public WebElement getSave() {
		return save;
	}

	/**
	 * @return the organizationHeaderValidate
	 */
	public WebElement getOrganizationHeaderValidate() {
		return organizationHeaderValidate;
	}

	/**
	 * @return the organizationNameValidate
	 */
	public WebElement getOrganizationNameValidate() {
		return organizationNameValidate;
	}

	/**
	 * @return the industryValidation
	 */
	public WebElement getIndustryValidation() {
		return industryValidation;
	}

	/**
	 * @return the typeValidation
	 */
	public WebElement getTypeValidation() {
		return typeValidation;
	}

	/**
	 * @return the phoneValidation
	 */
	public WebElement getPhoneValidation() {
		return phoneValidation;
	}

	/**
	 * @return the employeeValidation
	 */
	public WebElement getEmployeeValidation() {
		return employeeValidation;
	}

	public void createNewOrganization(String orgName)
	{
		getOrganizationName().sendKeys(orgName);
		getSave().click();
	}
	
	public void createNewOrganization(String orgName , String industry , String type)
	{
		getOrganizationName().sendKeys(orgName);
		getIndustryList().sendKeys(industry);
		getTypeList().sendKeys(type);
		getSave().click();
	}
	
	public void createNewOrganization(String orgName,String phoneNo)
	{
		getOrganizationName().sendKeys(orgName);
		getPhone().sendKeys(phoneNo);
		getSave().click();
	}
	
	public void createNewOrganizationWithEmp(String orgName,String emp)
	{
		getOrganizationName().sendKeys(orgName);
		getNoOfEmployees().sendKeys(emp);
		getSave().click();
	}
	
	
}
