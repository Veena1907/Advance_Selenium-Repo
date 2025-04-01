package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateContactsPage {

	WebDriver driver;

	public CreateContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "contactName")
	private WebElement contactsName;
	
	@FindBy(name = "organizationName")
	private WebElement organizationName;
	
	@FindBy(name = "mobile")
	private WebElement mobile;
	
	@FindBy(name = "title")
	private WebElement titleField;
	
	@FindBy(name = "email")
	private WebElement email;
	
	@FindBy(name = "department")
	private WebElement department;
	
	@FindBy(xpath = "//button[@type='button' and contains(@style,'white-space')]")
	private WebElement selectCampBtn;
	
	@FindBy(id= "search-criteria")
	private WebElement searchDD;
	
	@FindBy(id= "search-input")
	private WebElement searchInp;
	
	@FindBy(xpath = "//button[@class='select-btn']")
	private WebElement selectBtn;
	
	@FindBy(xpath = "//button[text()='Create Contact']")
	private WebElement createContactsBtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getContactsName() {
		return contactsName;
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getTitleField() {
		return titleField;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getDepartment() {
		return department;
	}

	public WebElement getSelectCampBtn() {
		return selectCampBtn;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchInp() {
		return searchInp;
	}

	public WebElement getSelectBtn() {
		return selectBtn;
	}

	public WebElement getCreateContactsBtn() {
		return createContactsBtn;
	}

	public void createContactWithCampaign(String org,String title,String cont,String mob,String childUrl,String parentUrl, String campName)
	{
		organizationName.sendKeys(org);
		titleField.sendKeys(title);
		contactsName.sendKeys(cont);
		mobile.sendKeys(mob);
		selectCampBtn.click();
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.switchToWindow(driver, childUrl);
		wUtil.select(searchDD, 1);
		searchInp.sendKeys(campName);
		selectBtn.click();
		wUtil.switchToWindow(driver, parentUrl);
		createContactsBtn.click();
	}
		
	
}
