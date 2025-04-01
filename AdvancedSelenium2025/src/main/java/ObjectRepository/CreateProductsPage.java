package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateProductsPage {

	WebDriver driver;

	public CreateProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "quantity")
	private WebElement quantity;
	
	@FindBy(name = "productName")
	private WebElement productName;
	
	@FindBy(name = "price")
	private WebElement proPrice;
	
	@FindBy(name = "productCategory")
	private WebElement productCategory;
	
	@FindBy(name = "vendorId")
	private WebElement selectVendor;
	
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement createProductsBtn;

	public WebElement getCreateProductsBtn() {
		return createProductsBtn;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getproPrice() {
		return proPrice;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public WebElement getselectVendor() {
		return selectVendor;
	}
	
	public void createProductstWithMandatoryFields(String proName, String quan , String price) throws InterruptedException
	{
		productName.sendKeys(proName);
		quantity.clear();
		quantity.sendKeys(quan);
		proPrice.clear();
		proPrice.sendKeys(price);
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.select(productCategory, 1);
		wUtil.select(selectVendor, 1);
		Thread.sleep(2000);
		createProductsBtn.click();
		
		
	}
		
}
