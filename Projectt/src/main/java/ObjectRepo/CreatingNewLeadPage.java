package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLeadPage {

	@FindBy(name = "lastname")
	private WebElement lastName;
	
	@FindBy(name = "company")
	private WebElement company;
	
	@FindBy(id = "noofemployees")
	private WebElement employees;
	
	@FindBy(id = "phone")
	private WebElement phone;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "state")
	private WebElement state;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	@FindBy(id = "mouseArea_Last Name")
	private WebElement lastNameValidation;
	
	@FindBy(id = "mouseArea_Company")
	private WebElement companyValidation;
	
	@FindBy(id = "mouseArea_Phone")
	private WebElement phoneValidation;
	
	@FindBy(id = "mouseArea_Email")
	private WebElement emailValidation;
	
	@FindBy(id = "mouseArea_No Of Employees")
	private WebElement employeeValidation;
	
	@FindBy(id = "mouseArea_City")
	private WebElement cityValidation;
	
	@FindBy(id = "mouseArea_State")
	private WebElement stateValidation;
	
	public CreatingNewLeadPage(WebDriver driver)
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
	 * @return the company
	 */
	public WebElement getCompany() {
		return company;
	}

	/**
	 * @return the employees
	 */
	public WebElement getEmployees() {
		return employees;
	}

	/**
	 * @return the phone
	 */
	public WebElement getPhone() {
		return phone;
	}

	/**
	 * @return the email
	 */
	public WebElement getEmail() {
		return email;
	}

	/**
	 * @return the city
	 */
	public WebElement getCity() {
		return city;
	}

	/**
	 * @return the state
	 */
	public WebElement getState() {
		return state;
	}

	/**
	 * @return the save
	 */
	public WebElement getSave() {
		return save;
	}
	
	/**
	 * @return the lastNameValidation
	 */
	public WebElement getLastNameValidation() {
		return lastNameValidation;
	}

	/**
	 * @return the companyValidation
	 */
	public WebElement getCompanyValidation() {
		return companyValidation;
	}

	/**
	 * @return the phoneValidation
	 */
	public WebElement getPhoneValidation() {
		return phoneValidation;
	}

	/**
	 * @return the emailValidation
	 */
	public WebElement getEmailValidation() {
		return emailValidation;
	}

	/**
	 * @return the employeeValidation
	 */
	public WebElement getEmployeeValidation() {
		return employeeValidation;
	}

	/**
	 * @return the cityValidation
	 */
	public WebElement getCityValidation() {
		return cityValidation;
	}

	/**
	 * @return the stateValidation
	 */
	public WebElement getStateValidation() {
		return stateValidation;
	}

	public void createNewLead(String lastName, String company)
	{
		getLastName().sendKeys(lastName);
		getCompany().sendKeys(company);
		getSave().click();
	}
	
	public void createNewLead(String lastName, String company, String phone, String email)
	{
		getLastName().sendKeys(lastName);
		getCompany().sendKeys(company);
		getPhone().sendKeys(phone);
		getEmail().sendKeys(email);
		getSave().click();
	}
	
	public void createNewLead(String lastName, String company,String empNo)
	{
		getLastName().sendKeys(lastName);
		getCompany().sendKeys(company);
		getEmployees().sendKeys(empNo);
		getSave().click();
	}
	
	public void createNewLeadWithAddress(String lastName, String company, String city, String state)
	{
		getLastName().sendKeys(lastName);
		getCompany().sendKeys(company);
		getCity().sendKeys(city);
		getState().sendKeys(state);
		getSave().click();
	}
	
}
