package Introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Testcase2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();	
		driver.findElement(By.name("campaignName")).sendKeys("Veena4");
		WebElement size = driver.findElement(By.name("targetSize"));
		size.clear();
		size.sendKeys("2");
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		Thread.sleep(2000);
		String ConfMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		if(ConfMsg.contains("Veena4"))
		{
			System.out.println("Campaign added successfully");
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
        
        driver.quit();
		

	}

}
