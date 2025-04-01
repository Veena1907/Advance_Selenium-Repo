package Login;
import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;

//@Listeners(ListenerImp.class)
public class LoginTest extends BaseClass {
	
	//@Parameters("browser")
	//@Test(groups= {"SmokeTest"})
	@Test(retryAnalyzer = genericListenerUtility.RetryListenerImp.class)
	public void loginTest() throws InterruptedException, IOException {
		
		String expectedURL="http://49.249.28.218:8098/dashboar";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Thread.sleep(2000);
		//verification of dashboard
		String actualURL=driver.getCurrentUrl();
//		SoftAssert sf= new SoftAssert();
//		sf.assertEquals(actualURL, expectedURL,"Validation is failed"); 
//		sf.assertAll(); // it will stops the execution if this is not given it will execute Reporter.log line also and give validation is passed
		Assert.assertEquals(actualURL, expectedURL,"Validation is failed"); //customizing the failed message
		Reporter.log("Validation is passed",true); //printing the message
		//logout
		
	}

	}

