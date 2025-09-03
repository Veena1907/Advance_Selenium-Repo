package CampaignTest;
import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CampaignsPage;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.DashboardPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;

//@Listeners(ListenerImp.class)
public class CreateCampaignTest extends BaseClass {
	
	//@Parameters("browser") {not necessary to give if we are passing in BaseClass because Lauch browser code is written in @BeforeClass}
	//@Test(groups= {"SmokeTest"})
	//@Test(priority=1)
	@Test()
	public void createCampaignTest() throws InterruptedException, IOException {
				
		JavaUtility jUtil= new JavaUtility();
		int ranNum= jUtil.getRandomNum(1000);
		
		//Excel 
		ExcelFileUtility exUtil= new ExcelFileUtility();
		String Campaign = exUtil.readingDataFromExcel("CampSheet", 1, 2)+ranNum;
		String targetSize = exUtil.readingDataFromExcel("CampSheet", 1, 3);
		//Printing the above values to understand 
		System.out.println(Campaign);
		System.out.println(targetSize);
		String expectedURL="http://49.249.28.218:8098/dashboard";
		driver.manage().window().maximize();
		WebDriverUtility webUtility= new WebDriverUtility();
		webUtility.waitForPageToLoad(driver);
		
		DashboardPage dp= new DashboardPage(driver);
		dp.getCampaignsLink().click();;
		CampaignsPage cp= new CampaignsPage(driver);
		cp.getCreateCampaignsBtn().click();
		CreateCampaignsPage ccp= new CreateCampaignsPage(driver);
		ccp.createCampaignWithmandatoryFields(Campaign,targetSize);
		Thread.sleep(5000);
		String ConfMsg=cp.getConfMsg().getText();
		boolean status = ConfMsg.contains(Campaign);
		Assert.assertEquals(status, true,"Campaign Not added");
		//Assert.assertTrue(status, "Campaign Not added");
		Reporter.log("Campaign " + Campaign +" added sucessfully",true);
//		if(ConfMsg.contains(Campaign))
//		{
//			Reporter.log("campaign "+ Campaign + " added successfully",true);
//		}
//		else
//		{
//			Reporter.log("campaign "+ Campaign + "not added",true);
//		}
		Thread.sleep(5000);
		
}
	//@Parameters("browser"){not necessary to give if we are passing in BaseClass because Lauch browser code is written in @BeforeClass}
	//@Test(groups= {"RegressionTest"})
	 @Test()
	public void createCampaignWithDateTest() throws InterruptedException, IOException {
		
		
		JavaUtility jUtil= new JavaUtility();
		int ranNum= jUtil.getRandomNum(1000);
		//Excel 
		ExcelFileUtility exUtil= new ExcelFileUtility();
		String Campaign = exUtil.readingDataFromExcel("CampSheet", 1, 2)+ranNum;
		String targetSize = exUtil.readingDataFromExcel("CampSheet", 1, 3);
		//Printing the above values to understand 
		System.out.println(Campaign);
		System.out.println(targetSize);
		
		String closeDate = jUtil.generateReqDate(30);
		String expectedURL="http://49.249.28.218:8098/dashboard";
		
		driver.manage().window().maximize();
		WebDriverUtility webUtility= new WebDriverUtility();
		webUtility.waitForPageToLoad(driver);
				
		DashboardPage dp=new DashboardPage(driver);
		Thread.sleep(2000);
		dp.getCampaignsLink().click();
		CampaignsPage cp= new CampaignsPage(driver);
		cp.getCreateCampaignsBtn().click();
		CreateCampaignsPage ccp= new CreateCampaignsPage(driver);
		ccp.createCampaignWithCloseDate(Campaign, targetSize, closeDate);
		Thread.sleep(5000);
		String ConfMsg=cp.getConfMsg().getText();
		boolean status = ConfMsg.contains(Campaign);
		Assert.assertEquals(status, true,"Campaign Not added");
		//Assert.assertTrue(status, "Campaign Not added");
		Reporter.log("Campaign " + Campaign +" added sucessfully",true);
		
//		if(ConfMsg.contains(Campaign))
//		{
//			Reporter.log("campaign " + Campaign +" added successfully",true);
//		}
//		else
//		{
//			Reporter.log("campaign " + Campaign + " not added",true);
//		}
		
}
}
