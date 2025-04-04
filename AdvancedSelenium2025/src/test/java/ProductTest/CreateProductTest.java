package ProductTest;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.CreateProductsPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.ProductPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;

//@Listeners(ListenerImp.class)
public class CreateProductTest extends BaseClass {
	//@Parameters("browser")
	//@Test(groups= {"IntegrationTest"})
	@Test()
	public void createProductTest() throws EncryptedDocumentException, IOException, InterruptedException {

		//Random Number for campaign name
		JavaUtility jUtil= new JavaUtility();
		int ranNum= jUtil.getRandomNum(1000);
		ExcelFileUtility excelUtil=new ExcelFileUtility();
		String ProName = excelUtil.readingDataFromExcel("ProSheet", 1, 2)+ranNum;
		String Quantity = excelUtil.readingDataFromExcel("ProSheet", 1, 3);
		String price = excelUtil.readingDataFromExcel("ProSheet", 1, 4);
		
		String expectedURL="http://49.249.28.218:8098/dashboard";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//navigating to ninza CRM
		
		Thread.sleep(2000);
		DashboardPage dp= new DashboardPage(driver);
		dp.getProductsLink().click();
		
		ProductPage pp = new ProductPage(driver);
		pp.getCreateProductsBtn().click();
		
		CreateProductsPage cpp = new CreateProductsPage(driver);
		cpp.createProductstWithMandatoryFields(ProName, Quantity, price);
		Thread.sleep(5000);
		String ConfMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		boolean status = ConfMsg.contains(ProName);
	     Assert.assertEquals(status, true, "Product not added Successfully");
	     //Assert.assertTrue(status, "Product not added Successfully");
	     Reporter.log("Product " + ProName +" added successfully",true);
	     
//		if(ConfMsg.contains(ProName))
//		{
//			Reporter.log("Product " + ProName +" added successfully",true);
//		}
//		else
//		{
//			Reporter.log("Product " + ProName +" not added",true);
//		}		
	
	}

}
