package fundmodule;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Baseclass.Baseclass1;
import Pomclasses.HomePage;
import Pomclasses.LoginPage;

public class verifyusercanclickonelment {
	static WebDriver driver;
	static HomePage hp;
	static LoginPage lp;
	static ExtentHtmlReporter  htmlreport;
	static ExtentReports reports;
	static ExtentTest extenttest;
	@BeforeClass()
	@Parameters("browser")
	public static void 	beforeClass(String browser) {
		htmlreport =Baseclass1.getextenthtmlreport();
		 reports = Baseclass1.getextentreport();
		 extenttest = Baseclass1.getextenttest("verifyusercanclickonelment");
		driver=Baseclass1.getdriver(browser);
	}
	@BeforeMethod()
	public static void 	beforeMethod() {
		
		hp=new HomePage(driver);
		lp=new LoginPage(driver);
		
	}
	@Test()
	public static void 	Verifyusercanclickonelement() throws InterruptedException {
		hp.switchtomainpage();
		hp.ClickOnElement();
		
	}
	@AfterMethod()
	public static void 	afterMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			extenttest.log(Status.PASS, result.getName());
		}
		if(result.getStatus()==ITestResult.FAILURE) {
			extenttest.log(Status.FAIL, result.getName());
		}
		if(result.getStatus()==ITestResult.SKIP) {
			extenttest.log(Status.SKIP, result.getName());
		}
		
	}
	@AfterClass()
	public static void 	afterClass() {
		reports.flush();
	
	}
	
	
	
}
