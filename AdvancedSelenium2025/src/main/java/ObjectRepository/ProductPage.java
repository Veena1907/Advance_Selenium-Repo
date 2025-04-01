package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
		
	@FindBy(xpath ="//span[text()='Add Product']")
	private WebElement createProductsBtn;
	
	@FindBy(xpath ="//div[@role='alert']")
	private WebElement confMsg;

	public WebElement getCreateProductsBtn() {
		return createProductsBtn;
	}

	public WebElement getConfMsg() {
		return confMsg;
	}
	
	
}
