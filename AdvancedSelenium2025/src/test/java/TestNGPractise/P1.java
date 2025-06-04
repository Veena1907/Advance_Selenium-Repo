package TestNGPractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class P1 {
		
		@Test(invocationCount=4 , threadPoolSize= 3)
		public void test1()
		{ 
			WebDriver driver= new ChromeDriver();
			System.out.println("Test 1");
			driver.get("https://chat.qspiders.com/");
			
		}
}
