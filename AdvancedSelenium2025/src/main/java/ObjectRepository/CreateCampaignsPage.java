package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignsPage {

	WebDriver driver;

	public CreateCampaignsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
 
	@FindBy(name = "campaignName")
	private WebElement campaignsName;
	
	@FindBy(name = "targetSize")
	private WebElement targetSize;
	
	@FindBy(name = "expectedCloseDate")
	private WebElement expectedCloseDate;
	
	@FindBy(name = "campaignStatus")
	private WebElement campaignStatus;
	
	@FindBy(name = "targetAudience")
	private WebElement targetAudience;
	
	@FindBy(name = "description")
	private WebElement description;
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement createCampaignsBtn;
	
	public WebElement getCampaignsName() {
		return campaignsName;
	}

	public WebElement getTargetSize() {
		return targetSize;
	}
	
	public WebElement getCampaignStatus() {
		return campaignStatus;
	}

	public WebElement getTargetAudience() {
		return targetAudience;
	}

	public WebElement getDescription() {
		return description;
	}
	 
	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getCreateCampaigns() {
		return createCampaignsBtn;
	}
	public void createCampaignWithmandatoryFields(String campName,String target )
	{
		campaignsName.sendKeys(campName);
		targetSize.clear();
		targetSize.sendKeys(target);
		createCampaignsBtn.click();
	}
	
	public void createCampaignWithCloseDate(String campName,String target ,String date)
	{
		campaignsName.sendKeys(campName);
		targetSize.clear();
		targetSize.sendKeys(target);
		expectedCloseDate.sendKeys(date);
		createCampaignsBtn.click();
	}
	
	
}
