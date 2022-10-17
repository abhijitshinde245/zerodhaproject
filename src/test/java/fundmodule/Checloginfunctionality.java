package fundmodule;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import Baseclass.Baseclass1;
import Pomclasses.HomePage;
import Pomclasses.LoginPage;
import utilclass.UtilClass1;

public class Checloginfunctionality {

	static WebDriver driver;
	static LoginPage lp;
	static HomePage hp;
	static ExtentHtmlReporter  htmlreport;
	static ExtentReports reports;
	static ExtentTest extenttest;
	@BeforeClass
	@Parameters("browser")
	public static void beforeclass(String browser) {
		 htmlreport =Baseclass1.getextenthtmlreport();
		 reports = Baseclass1.getextentreport();
		 extenttest = Baseclass1.getextenttest("Checloginfunctionality");
		 driver=Baseclass1.getdriver(browser);
		 
	}
	@BeforeMethod
	public static void beforemethod() {
		 lp = new LoginPage(driver);
		 hp = new HomePage(driver);
		 
		 
	}
	
	@Test
	public static void Verifyusercanlogin() throws IOException, InterruptedException {
		lp.Userid();
		lp.Password();
		lp.Submitbutton();
		Thread.sleep(7000);
		if(lp.getprofilename().equals("Abhijeet"))
		{
			System.out.println("User can login test case passed" );
		}else {
			System.out.println("Test case fail");
		}
		//Assert.assertEquals(lp.getprofilename(), "Abhijeet");
	    }
	@Test
		public static void verifyusercanaddfund() throws InterruptedException {
			hp.Fundbutton();
			hp.Addfundbotton();
			hp.switchtopage();
			hp.addmoney();
			hp.Continuebutton();
		}
		
	
	@AfterMethod
	public static void aftermethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.SUCCESS) {
			String destination = UtilClass1.screenshot(driver,result.getName());
			extenttest.log(Status.PASS, result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(destination).build());
		}
		if(result.getStatus()==ITestResult.FAILURE) {
			extenttest.log(Status.FAIL, result.getName());
		}
		if(result.getStatus()==ITestResult.SKIP) {
			extenttest.log(Status.SKIP, result.getName());
		}
		
	}
	@AfterClass
	public static void afterclass() {
		reports.flush();
		Baseclass1.unloaddriver();
		
	}
}
