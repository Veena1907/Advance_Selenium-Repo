package genericListenerUtility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import GenericUtility.UtilityClassObject;
import genericBaseClassUtility.BaseClass;


public class ListenerImp implements ITestListener,ISuiteListener {

	public static ExtentReports report=null;
	public ExtentSparkReporter spark=null;
	public static ExtentTest test=null; // used for log instead of sopln use test.log

	@Override
	//this method is exactly same as @BeforeSuite annotation
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		Date date = new Date();
		SimpleDateFormat sim=new SimpleDateFormat("HH-mm-ss");
		String time = sim.format(date);
		System.out.println(time);
		   // or
		//String time=new Date().toString().replace(" ", "_").replace(":", " ");  
		
		//Spark report config
		spark=new ExtentSparkReporter("./AdvancedReports/report"+time+".html"); //report is getting generated here
		spark.config().setDocumentTitle("Ninza_CRM_Project_Results");
		spark.config().setReportName("CRM_Report");
		spark.config().setTheme(Theme.DARK);
		
		//add Enviornment information and create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "Chrome-135");
		report.setSystemInfo("Env", "Production");

	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		Date date = new Date();
		SimpleDateFormat sim=new SimpleDateFormat("HH-mm-ss");
		String time = sim.format(date);
		System.out.println(time);
	}

	@Override
	//it will execute before every testscripts
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " Starts ");
		test=report.createTest(result.getMethod().getMethodName());
		//UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+" Started "); //in every log we can specify the Status information
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " ends ");
		test.log(Status.PASS, result.getMethod().getMethodName()+" Ended "); 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testcaseName=result.getMethod().getMethodName();
		Date date = new Date();
		SimpleDateFormat sim=new SimpleDateFormat("HH-mm-ss");
		String time = sim.format(date);
		 // or
		//String time=new Date().toString().replace(" ", "_").replace(":", " ");  
		 
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		String temp = ts.getScreenshotAs(OutputType.BASE64); //for extend report we use BASE64
		File temp1 = ts.getScreenshotAs(OutputType.FILE);
		
		File dest=new File("./ScreenShot/"+testcaseName+"_"+time+".png");
		try {
			FileHandler.copy(temp1, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromBase64String(temp,"Failed"+testcaseName); //attaching screenshot to extend report
		
		test.log(Status.FAIL, result.getMethod().getMethodName()+" Failed ");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
	}
		

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		//using this we can take the backup of the log of reports if don't use flush method our report will not be saved
		
		report.flush(); 
	}
	

}
