package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	WebDriver driver;

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
		
	@FindBy(xpath ="//span[text()='Create Contact']")
	private WebElement createContactsBtn;
	
	@FindBy(xpath ="//div[@role='alert']")
	private WebElement confMsg;
	
	public WebElement getCreateContactsBtn() {
		return createContactsBtn;
	}

	public WebElement getConfMsg() {
		return confMsg;
	}
}
