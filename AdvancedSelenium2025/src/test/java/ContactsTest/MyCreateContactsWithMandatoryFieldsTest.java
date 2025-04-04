package ContactsTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesFileUtility;

public class MyCreateContactsWithMandatoryFieldsTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		PropertiesFileUtility propUtil= new PropertiesFileUtility();
		String BROWSER = propUtil.readingDataFromPropertiesFile("browser");
		String URL = propUtil.readingDataFromPropertiesFile("url");
		String UN = propUtil.readingDataFromPropertiesFile("uname");
		String PWD = propUtil.readingDataFromPropertiesFile("pwd");
		
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
		//Create System Generated date or todays date as per system we use Date class in Java util package
		Date dateObj= new Date();
		//Setting the format
		SimpleDateFormat sim= new SimpleDateFormat("dd-MM-YYYY");
		String todayDate = sim.format(dateObj);
		System.out.println("Todays Date:- "+todayDate);
		
		Calendar cal= sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String closeDate = sim.format(cal.getTime());
		System.out.println("Close date:- "+closeDate);
		
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(UN);
		driver.findElement(By.id("inputPassword")).sendKeys(PWD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(Campaign);
		WebElement Size = driver.findElement(By.name("targetSize"));
		Size.clear();
		Size.sendKeys(targetSize);
		driver.findElement(By.xpath("//input[@name='expectedCloseDate']")).sendKeys(closeDate);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		Thread.sleep(2000);
		 String confMSG = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		if(confMSG.contains(Campaign))
		{
			System.out.println("Campaign created successfully");
		}
		else
		{
			System.out.println("Campaign not added successfully");
		}
		Thread.sleep(4000);
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		driver.findElement(By.name("contactName")).sendKeys(ContactName);
		driver.findElement(By.name("organizationName")).sendKeys(OrgName);
		driver.findElement(By.name("mobile")).sendKeys(Mobile);
		driver.findElement(By.name("title")).sendKeys(Title);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(2000);
		String parentWindow = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> itr=s.iterator();
		while(itr.hasNext())
		{
			String ref = itr.next();
			if(!ref.equals(parentWindow)) {
				driver.switchTo().window(ref);	
			}
		}
		WebElement ListBox = driver.findElement(By.id("search-criteria"));
		Select s1= new Select(ListBox);
		Thread.sleep(2000);
		s1.selectByValue("campaignName");
		driver.findElement(By.id("search-input")).sendKeys(Campaign);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button)[1]")).click();
		Thread.sleep(2000);
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
		Thread.sleep(2000);
		 String confMSG1 = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		if(confMSG1.contains(ContactName))
		{
			System.out.println("Contact created successfully");
		}
		else
		{
			System.out.println("Not added successfully");
		}
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='user-icon']")).click();
		WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
        Actions action=new Actions(driver);
        action.moveToElement(logoutBtn).click().perform();
        //close the browser
        driver.quit();
	}
	}

