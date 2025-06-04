import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ObjectRepository.ContactsPage;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeContains;

public class Practise {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get("https://www.facebook.com/");
		WebElement ele = driver.findElement(By.id("email"));
		ele.sendKeys("sajdlaskn");
			ele.sendKeys(Keys.CONTROL+"a");
			ele.sendKeys(Keys.CONTROL+"c");
			driver.findElement(By.id("pass")).sendKeys(Keys.CONTROL+"v");
		 
		 
		

	}

}
