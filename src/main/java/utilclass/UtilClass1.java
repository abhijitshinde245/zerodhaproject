package utilclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilClass1 {

	static WebDriver driver;
	public static String getdata(String key) throws IOException {
		FileInputStream data = new FileInputStream("C:\\Users\\Abhijit shinde\\eclipse-workspace\\mavenzerodhaproject\\Configuration\\config.properties");
		Properties p = new Properties();
		p.load(data);
		String inputdata = p.getProperty(key);
		return inputdata;
		
	
	}
	public static WebDriverWait explicitlywait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	return wait;
	}
	public static String screenshot(WebDriver driver,String testname) throws IOException {
		String destination = ""+testname+" .jpg";
		File Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File path = new File(destination);
		FileHandler.copy(Screenshot, path);
		return destination;
	}
}
