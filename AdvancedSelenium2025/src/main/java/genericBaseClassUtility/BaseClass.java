package genericBaseClassUtility;

import java.io.IOException;
import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import GenericUtility.DatabaseUtility;
import GenericUtility.PropertiesFileUtility;
import GenericUtility.UtilityClassObject;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver=null;
	//this sdriver is created to use in Listener class 
	public static WebDriver sdriver=null; //if we give static variable we cannot perform parallel execution as static varaible will have only one instance
	DatabaseUtility dbUtil=new DatabaseUtility();
	PropertiesFileUtility pro=new PropertiesFileUtility();
	@BeforeSuite
	public void beforeSuite() throws SQLException
	{
		System.out.println("Established database connection");
		dbUtil.getDBConnection("jdbc:mysql://localhost:3306/Ninza_E18", "root", "Nokia@2690");
	}
	@BeforeTest
	
	public void beforetest()
	{
		System.out.println("Pre configuration Setup");
	}
	
	//@Parameters("browser") for crossBrowserTesting
	@BeforeClass
	//public void beforeClass(String browser) throws IOException {for crossBrowserTesting}
	public void beforeClass() throws IOException
	{
		System.out.println("Launch the browser");
		//String BROWSER=browser; reading from crossBrowsertesting.xml
		
		String BROWSER = pro.readingDataFromPropertiesFile("browser"); //from properties file
		//String BROWSER = System.getProperty("browser"); //for maven command line
		if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
	else if(BROWSER.equalsIgnoreCase("edge"))
		{
		driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		  sdriver=driver; //pass the value of driver to sdriver
		 // UtilityClassObject.setDriver(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		System.out.println("Login");
		String URL = pro.readingDataFromPropertiesFile("url");
		String UN = pro.readingDataFromPropertiesFile("uname"); //from propertiesfile
		  //String UN = System.getProperty("uname"); //reading from maven cmd line
		//  String PWD = System.getProperty("pwd"); //reading from maven cmd line
		String PWD = pro.readingDataFromPropertiesFile("pwd"); //from propertiesfile
		driver.get(URL);
		LoginPage lp= new LoginPage(driver);
		lp.login(UN, PWD);
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Logout");
		DashboardPage dp= new DashboardPage(driver);
		dp.logout();
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("Close the Browser");
		driver.quit();
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("Post Configuration SetUp");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("Close the database connection");
		dbUtil.closeDBConnection();
	}

}
