package Baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass1 {
	static WebDriver driver;
	static ExtentHtmlReporter  htmlreport;
	static ExtentReports reports;
	static ExtentTest extenttest;
	
	public static WebDriver getdriver(String browser) {
		if(driver==null) {
			if(browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
			}else {
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
			}
		
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		return driver;
	}
	public static ExtentHtmlReporter getextenthtmlreport() {
		if(htmlreport==null) {
		 htmlreport = new ExtentHtmlReporter("reports.html");
		}
		return htmlreport;
	}
	public static ExtentReports getextentreport() {
		if(reports==null) {
			reports =  new ExtentReports();
			reports.attachReporter(htmlreport);
		}
		return reports;
	}
	public static ExtentTest getextenttest(String testname) {
	  extenttest = reports.createTest(testname);
	  return extenttest;
	 
	 
	}
	public static void unloaddriver() {
		driver = null;
	}
	
}
