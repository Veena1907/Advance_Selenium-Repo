package Introduction;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Practise {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis= new FileInputStream("C:\\QA-23_M32\\ AdvanceSelenium\\src\\test\\resources\\Commondata.properties");
		Properties p= new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String UN = p.getProperty("uname");
		String PWD = p.getProperty("pwd");
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
		driver.findElement(By.name("campaignName")).sendKeys("veena21w3");
		WebElement targetSize = driver.findElement(By.name("targetSize"));
		targetSize.clear();
		targetSize.sendKeys("100");
		driver.findElement(By.xpath("//input[@name='expectedCloseDate']")).sendKeys("04-03-2025");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		Thread.sleep(2000);
		 String confMSG = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		if(confMSG.contains("veena"))
		{
			System.out.println("Campaign created successfully");
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
