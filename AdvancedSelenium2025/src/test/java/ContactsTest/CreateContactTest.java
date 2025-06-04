package ContactsTest;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CampaignsPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.CreateContactsPage;
import ObjectRepository.DashboardPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;

//@Listeners(ListenerImp.class)
public class CreateContactTest extends BaseClass{
	
	//@Parameters("browser")
	//@Test(groups= {"RegressionTest"})
	@Test()
	public void createContactTest() throws IOException, InterruptedException {
				
		//Random Number for campaign name
				JavaUtility jUtil= new JavaUtility();
				int ranNum= jUtil.getRandomNum(1000);
				//Excel 
				ExcelFileUtility exUtil= new ExcelFileUtility();
				String Campaign = exUtil.readingDataFromExcel("CampSheet", 1, 2)+ranNum;
				String targetSize = exUtil.readingDataFromExcel("CampSheet", 1, 3);
				String ContactName = exUtil.readingDataFromExcel("ContSheet", 2, 2)+ranNum;
				String OrgName = exUtil.readingDataFromExcel("ContSheet", 2, 3);
				String Mobile = exUtil.readingDataFromExcel("ContSheet", 2, 4);
				String Title = exUtil.readingDataFromExcel("ContSheet", 2, 5);
				//Printing the above values to understand 
				System.out.println("Campaign name is:-"+ Campaign);
				System.out.println("Campaign Target size:-"+ targetSize);
				System.out.println("Contact name is:-"+ ContactName);
				System.out.println("Organization Name:-"+ OrgName);
				System.out.println("Mobile is:-"+ Mobile);
				System.out.println("Title is:-"+ Title);
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				DashboardPage dp= new DashboardPage(driver);
				dp.getCampaignsLink().click();
				
				CampaignsPage cp= new CampaignsPage(driver);
				cp.getCreateCampaignsBtn().click();
				
				CreateCampaignsPage ccp= new CreateCampaignsPage(driver);
				ccp.createCampaignWithmandatoryFields(Campaign,targetSize);
				Thread.sleep(3000);
				
				WebElement contactLink = dp.getContactsLink();
				WebDriverUtility Wutil = new WebDriverUtility();
				Wutil.waitForElementToBeClickable(driver, contactLink, 20);
				contactLink.click();
				
				Thread.sleep(5000);
				ContactsPage ccp1=new ContactsPage(driver);
				WebElement createContactBtn = ccp1.getCreateContactsBtn();
				Wutil.waitForElementToBeClickable(driver, createContactBtn, 20);
				createContactBtn.click();
				
				CreateContactsPage cct= new CreateContactsPage(driver);
				cct.createContactWithCampaign(OrgName, Title, ContactName, Mobile, "selectCampaign", "create-contact", Campaign);
				 Thread.sleep(5000);
				 
		       String ConfirmationMsg =ccp1.getConfMsg().getText();
		     boolean status = ConfirmationMsg.contains(ContactName);
		     Assert.assertEquals(status, true, "Contact not added Successfully");
		     //Assert.assertTrue(status, "Contact not added Successfully");
		     Reporter.log("Contact " + ContactName + " added Successfully",true);
		     
//		        if(ConfirmationMsg.contains(ContactName))
//		        {
//		        	Reporter.log("Contact " + ContactName + " added Successfully",true);
//		        }
//		        else
//		        {
//		        	Reporter.log("Contact " + ContactName + " not added",true);
//		        }
//		    
			}

		}


