package com.ObjectRepository;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

 
 

public class BigW_Test {
	

	public static WebDriver driver;
	Logger log = Logger.getLogger(BigW_Test.class);
	 static ExtentHtmlReporter extend_reporter =new ExtentHtmlReporter("C:\\Users\\JB JK\\Pictures\\eclipsss\\BigW_Test\\test\\ExtentReport.html");
		public  static ExtentReports extent;
		public  static ExtentTest extentTest;
		
	public static  void extent() {
		
		extent = new ExtentReports();
		extent.attachReporter(extend_reporter);
		extent.setSystemInfo("Host_Name", "JbJk_Windows");
		extent.setSystemInfo("User_Name", "Sellamuthu G");
		extent.setSystemInfo("Environment", "QA");
		extentTest= extent.createTest("Bigw scenario Validate Test");
		 
	}
   
	
	
	
//	@BeforeSuite
//	public void setExtent(){
//		extent = new ExtentReports();
//		extent.attachReporter(extend_reporter);
//		extent.setSystemInfo("Host_Name", "JbJk_Windows");
//		extent.setSystemInfo("User_Name", "Sellamuthu G");
//		extent.setSystemInfo("Environment", "QA");
//		
//	}
	
	
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	
	
	
	@BeforeTest
	public void setup(){
		 extentTest= extent.createTest("Bigw scenario Validate Test");
		 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\JB JK\\Desktop\\smt java\\geckodriver-v0.21.0-win64\\english\\ExtentReportCode\\Driver\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.navigate().to("https://www.bigw.com.au/");
		driver.findElement(By.xpath("//span[.='×']")).click();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
 
		}
	@Test(priority=1,enabled=true)
	public void Validate_Big_W_App()  {
		WebElement loc = driver.findElement(By.xpath("(//*[.='Set your location'])[2]"));
		WebDriverWait wait= new WebDriverWait(driver, 20);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(loc));
		until.click();
		driver.findElement(By.id("userLocationInput")).sendKeys("2150");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> locDrop = driver.findElements(By.xpath("//ul[@id='ui-id-1']//li"));
		for (int i = 0; i <locDrop.size() ; i++) {
			System.out.println(locDrop.get(i).getText());
			if (locDrop.get(i).getText().equals("2150 HARRIS PARK NSW")) {
				locDrop.get(i).click();
			}
			}
		    boolean b = driver.findElement(By.xpath("//span[.='2150 HARRIS PARK']")).isDisplayed();
		    Assert.assertTrue(b);
		    driver.navigate().to("https://www.bigw.com.au/product/dyson-dirt-brush-stubborn-918507-04/p/634813/");
			WebElement addToCart = driver.findElement(By.xpath("//button[@id='addToCartButton' and @type='submit']"));
			WebDriverWait cartWait=new WebDriverWait(driver, 20);
			WebElement WaitForCartElement = cartWait.until(ExpectedConditions.elementToBeClickable(addToCart));
			WaitForCartElement.click();
			String updatedCart = driver.findElement(By.xpath("//a[@href='/cart']//child::span[.='$29.00']")).getText();
		    Assert.assertEquals(updatedCart, "$29.00");
		    extentTest.log(Status.INFO, "$29.00 cart icon Validated Successfully");
	}
	 
	 

	//@AfterMethod
//	public  static void fail_screenShot(ITestResult result) throws IOException{
//		
//		if(result.getStatus()==ITestResult.FAILURE){
//			extentTest.log(Status.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
//			extentTest.log(Status.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
//			
//			String screenshotPath = BigW_Test.getScreenshot(driver, result.getName());
//			extentTest.log(Status.FAIL, (Markup) extentTest.addScreenCaptureFromPath(screenshotPath));  
//		}
//		else if(result.getStatus()==ITestResult.SKIP){
//			extentTest.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
//		}
//		else if(result.getStatus()==ITestResult.SUCCESS){
//			extentTest.log(Status.PASS, "Test Case PASSED IS " + result.getName());
//
//		}
//		extent.flush();
//		
//	}
	
	
	
	@AfterTest
	public void endReport(){
		 
		driver.quit();
		
		 
		
	}

}

