package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	
	WebDriver driver;

	public CampaignsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath ="//span[text()='Create Campaign']")
	private WebElement createCampaignsBtn;
	
	@FindBy(xpath ="//select[@class='form-control']")
	private WebElement searchByID;
	
	@FindBy(xpath ="//input[@placeholder='Search by Campaign Id']")
	private WebElement searchField;
	
	
	@FindBy(xpath ="//div[@role='alert']")
	private WebElement confMsg;

	public WebElement getCreateCampaignsBtn() {
		return createCampaignsBtn;
	}
	
	public WebElement getSearchByDD() {
		return searchByID;
	}

	public WebElement getSearchField() {
		return searchField;
	}
	
	public WebElement getConfMsg() {
		return confMsg;
	}

	
}
